/**
 * 
 */
package com.ecommerce.bulk.order.config;

/**
 * @author amit.basnak
 *
 */

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.core.io.ClassPathResource;
import static com.ecommerce.bulk.order.constants.OrderBatchJobConstant.*;
import com.ecommerce.bulk.order.listener.OrderJobListener;
import com.ecommerce.bulk.order.model.Order;
import com.ecommerce.bulk.order.processor.OrderProcessor;

@EnableBatchProcessing
public class BatchConfig
{
	
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	
	@Value("${app.csv.fileHeaders}")
    private String[] names;
	
	 @Bean
	 public FlatFileItemReader<Order> reader()
	 {
	        return new FlatFileItemReaderBuilder<Order>()
	                .name(ORDER_ITEM_READER)
	                .resource(new ClassPathResource("csv/orders.csv"))
	                .linesToSkip(1)
	                .delimited()
	                .names(names)
	                .lineMapper(lineMapper())
	                .fieldSetMapper(new BeanWrapperFieldSetMapper<Order>() {{
	                    setTargetType(Order.class);
	                }}).build();
	 }
	 
	 @Bean
	 public LineMapper<Order> lineMapper()
	 {
	        final DefaultLineMapper<Order> defaultLineMapper = new DefaultLineMapper<>();
	        final DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
	        lineTokenizer.setDelimiter(",");
	        lineTokenizer.setStrict(false);
	        lineTokenizer.setNames(names);
	        defaultLineMapper.setLineTokenizer(lineTokenizer);
	        defaultLineMapper.setFieldSetMapper(null);
	        return defaultLineMapper;
	 }
	 
	 @Bean
	 public OrderProcessor processor() 
	 {
	        return new OrderProcessor();
	 }
	 
	 @Bean
	 public JdbcBatchItemWriter<Order> writer(final DataSource dataSource) 
	 {
	        return new JdbcBatchItemWriterBuilder<Order>()
	                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	                .sql("INSERT INTO ORDER (orderNumber, orderTrackingNumber, orderDate, orderTotal, user, "
	                		+ "shippingAddress, billingAddress, account , orderItems) VALUES (:orderNumber, :orderTrackingNumber, :orderDate, "
	                		+ ":orderTotal, :user, :shippingAddress, :billingAddress, :account, :orderItems)")
	                .dataSource(dataSource)
	                .build();
	 }
	 
	 @Bean
	 public Step step(JdbcBatchItemWriter<Order> writer)
	 {
	        return stepBuilderFactory.get(BATCH_STEP)
	                .<Order, Order> chunk(25)
	                .reader(reader())
	                .processor(processor())
	                .writer(writer)
	                .build();
	 }
	 
	 @Bean
	 public Job job(OrderJobListener listener, Step step)
	 {
	        return jobBuilderFactory.get(ORDER_PROCESS_JOB)
	                .incrementer(new RunIdIncrementer())
	                .listener(listener)
	                .flow(step)
	                .end()
	                .build();
	 }
}
