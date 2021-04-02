package com.ecommerce.pricing.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.ecommerce.pricing.model.Pricing;

public interface PricingDaoRepository extends PagingAndSortingRepository<Pricing, Long> 
{
	
}
