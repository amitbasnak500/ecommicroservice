package com.ecommerce.pricing.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ecommerce.pricing.model.Pricing;

public interface PricingService
{
   Pricing save(Pricing pricing);
   Optional<Pricing> get(long id);
   Page<Pricing> getPricingsByPage(Integer pageNumber, Integer pageSize);
   void update(long id, Pricing pricing);
   void delete(long id);
}
