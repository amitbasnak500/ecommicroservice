package com.ecommerce.bulk.order;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableBatchProcessing
@SpringBootApplication
public class EcommerceBulkOrderApiApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(EcommerceBulkOrderApiApplication.class, args);
	}
}
