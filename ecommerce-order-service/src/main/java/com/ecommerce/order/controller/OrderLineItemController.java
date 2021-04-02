package com.ecommerce.order.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order.events.OrderLineItemEvent;
import com.ecommerce.order.model.OrderLineItem;
import com.ecommerce.order.service.OrderLineItemService;

@RestController
@RequestMapping(value="/api")
public class OrderLineItemController extends AbstractController
{

   @Autowired
   OrderLineItemService  orderLineItemService;
   
   @PostMapping("/order-item")
   public ResponseEntity<?> createOrderLineItemLineItem(@RequestBody OrderLineItem order)
   {
      OrderLineItem savedOrderLineItem = orderLineItemService.save(order);
      OrderLineItemEvent OrderLineItemCreatedEvent = new OrderLineItemEvent(this, "OrderLineItemCreatedEvent", savedOrderLineItem);
      eventPublisher.publishEvent(OrderLineItemCreatedEvent);
      return ResponseEntity.ok().body("New OrderLineItem has been saved with ID:" + savedOrderLineItem.getId());
   }

   @GetMapping("/order-item/{id}")
   @ResponseBody
   public OrderLineItem getOrderLineItem(@PathVariable("id") long id)
   {
	  Optional<OrderLineItem> returnedOrderLineItem = orderLineItemService.get(id);
	  OrderLineItem OrderLineItem  = returnedOrderLineItem.get(); 
	  
	  OrderLineItemEvent OrderLineItemCreatedEvent = new OrderLineItemEvent(this, "OrderLineItemRetrievedEvent", OrderLineItem);
      eventPublisher.publishEvent(OrderLineItemCreatedEvent);
      return OrderLineItem;
   }
  
   @PutMapping("/order-item/{id}")
   public ResponseEntity<?> updateOrderLineItem(@PathVariable("id") long id, @RequestBody OrderLineItem order)
   {
	  checkResourceFound(this.orderLineItemService.get(id));
	  orderLineItemService.update(id, order);
      return ResponseEntity.ok().body("OrderLineItem has been updated successfully.");
   }

  
   @DeleteMapping("/order-item/{id}")
   public ResponseEntity<?> deleteOrderLineItem(@PathVariable("id") long id) 
   {
	  checkResourceFound(this.orderLineItemService.get(id));
	  orderLineItemService.delete(id);
      return ResponseEntity.ok().body("OrderLineItem has been deleted successfully.");
   }
}