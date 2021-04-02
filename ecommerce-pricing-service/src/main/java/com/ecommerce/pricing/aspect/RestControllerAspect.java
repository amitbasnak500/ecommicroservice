package com.ecommerce.pricing.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerAspect
{

	private final Logger logger = LoggerFactory.getLogger("RestControllerAspect");
	
	@Before("execution(public * com.ecommerce.pricing.controller.*Controller.*(..))")
	public void generalAllMethodASpect() 
	{
		logger.info("All Method Calls invoke this general aspect method");
	}
	
	@AfterReturning("execution(public * com.ecommerce.pricing.controller.*Controller.createPricing(..))")
	public void getsCalledOnPricingSave() 
	{
		logger.info("This aspect is fired when the createPricing method of the controller is called");
		
	}
}
