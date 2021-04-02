package com.ecommerce.order.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ecommerce.order.model.Shipping;

public interface ShippingService
{
   Shipping save(Shipping shipping);
   Optional<Shipping> get(long id);
   Page<Shipping> getShippingsByPage(Integer pageNumber, Integer pageSize);
   void update(long id, Shipping shipping);
   void delete(long id);
}
