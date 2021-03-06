package com.ecommerce.order.events;


import org.springframework.context.ApplicationEvent;
import com.ecommerce.order.model.Order;

public class OrderEvent extends ApplicationEvent
{

	private static final long serialVersionUID = 6098955420452777027L;
	private String eventType;
	private Order order;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderEvent(Object source, String eventType, Order order) {
		super(source);
		this.eventType = eventType;
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderEvent [eventType=" + eventType + ", order=" + order + "]";
	}
  
}
