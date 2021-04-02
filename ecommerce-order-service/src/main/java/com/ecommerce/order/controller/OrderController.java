package com.ecommerce.order.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

import com.ecommerce.order.events.OrderEvent;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.OrderService;

@RestController
@RequestMapping(value="/api")
public class OrderController extends AbstractController 
{

	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrderService  orderService;
   
   @PostMapping("/order")
   public ResponseEntity<?> createOrder(@RequestBody Order order) 
   {
	   try
	   {
			   Order savedOrder = orderService.save(order);
		      OrderEvent OrderCreatedEvent = new OrderEvent(this, "OrderCreatedEvent", savedOrder);
		      eventPublisher.publishEvent(OrderCreatedEvent);
		      return ResponseEntity.ok().body("New Order has been saved with ID:" + savedOrder.getId());
	   }
	   catch(Exception ex)
	   {
	    	  log.error("Received Bad Request Exception"+ex.getLocalizedMessage());
	    	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	   }
   }

   
   @GetMapping("/order/{id}")
   @ResponseBody
   public ResponseEntity<Object> getOrder(@PathVariable("id") long id) 
   {
	  try
	  {
		  Optional<Order> returnedOrder = orderService.get(id);
		  if(returnedOrder.isPresent())
		  {
			  Order orderObj = returnedOrder.get();
			  OrderEvent OrderCreatedEvent = new OrderEvent(this, "OrderRetrievedEvent", orderObj);
		      eventPublisher.publishEvent(OrderCreatedEvent);
		      return ResponseEntity.status(HttpStatus.OK).body(orderObj);
		  }
		  else
		  {
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		  }	 
	  }
	  catch (Exception ex) 
	  {
			log.error("Received Bad Request Exception"+ex.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	  }
	 
   }
   
   @GetMapping("/order")
   public @ResponseBody Page<Order> getCategoriesByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize)
   {
      Page<Order> pagedOrders = orderService.getOrdersByPage(pageNumber, pageSize);
      return pagedOrders;
   }

   @PutMapping("/order/{id}")
   public ResponseEntity<?> updateOrder(@PathVariable("id") long id, @RequestBody Order order)
   {
	  try
	  {
		  checkResourceFound(this.orderService.get(id));
		  orderService.update(id, order);
	      return ResponseEntity.ok().body("Order has been updated successfully.");
	  }
	  catch (Exception ex) 
	  {
			log.error("Received Bad Update Request Exception"+ex.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	  }	   
   }

  
   @DeleteMapping("/order/{id}")
   public ResponseEntity<?> deleteOrder(@PathVariable("id") long id) 
   {
	  try
	  {
		  checkResourceFound(this.orderService.get(id));
		  orderService.delete(id);
	      return ResponseEntity.ok().body("Order has been deleted successfully.");
	  }
	  catch (Exception ex) 
	  {
			log.error("Received Bad Delete Request Exception"+ex.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	  }	  
	 
   }
}
