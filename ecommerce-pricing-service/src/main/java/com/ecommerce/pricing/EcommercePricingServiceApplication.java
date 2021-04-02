package com.ecommerce.pricing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EcommercePricingServiceApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(EcommercePricingServiceApplication.class, args);
	}

}
