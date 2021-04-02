package com.ecommerce.order.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import com.ecommerce.order.model.OrderLineItem;

public interface OrderLineItemService
{
   OrderLineItem save(OrderLineItem orderLineItem);
   Optional<OrderLineItem> get(long id);
   Page<OrderLineItem> getOrderLineItemsByPage(Integer pageNumber, Integer pageSize);
   void update(long id, OrderLineItem orderLineItem);
   void delete(long id);
}
