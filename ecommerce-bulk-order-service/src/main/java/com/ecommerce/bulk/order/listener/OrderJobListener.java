/**
 * 
 */
package com.ecommerce.bulk.order.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;
import static org.springframework.batch.core.BatchStatus.*;

/**
 * @author amit.basnak
 *
 */
@Component
public class OrderJobListener extends JobExecutionListenerSupport 
{
	private final Logger logger = LoggerFactory.getLogger("OrderJobListener"); 
	
	@Override
	 public void beforeJob(JobExecution jobExecution) 
	 {
	        if (jobExecution.getStatus() == STARTED)
	        {
	        	logger.info("ORDER BATCH PROCESS STARTED...!");
	        }
	 }
	 
	 @Override
	 public void afterJob(JobExecution jobExecution)
	 {
	        if (jobExecution.getStatus() == COMPLETED)
	        {
	        	logger.info("ORDER BATCH PROCESS COMPLETED...!");
	        }
	  }

}
