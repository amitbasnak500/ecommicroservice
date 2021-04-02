package com.ecommerce.order.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ecommerce.order.model.Order;

public interface OrderService
{
   Order save(Order order);
   Optional<Order> get(long id);
   Page<Order> getOrdersByPage(Integer pageNumber, Integer pageSize);
   void update(long id, Order order);
   void delete(long id);
}
