package com.ecommerce.order.events;


import org.springframework.context.ApplicationEvent;
import com.ecommerce.order.model.OrderLineItem;

public class OrderLineItemEvent extends ApplicationEvent
{

	private static final long serialVersionUID = 3793873418335815154L;
	private String eventType;
	private OrderLineItem orderItem;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public OrderLineItem getOrderLineItem() {
		return orderItem;
	}
	public void setOrderLineItem(OrderLineItem orderItem) {
		this.orderItem = orderItem;
	}
	public OrderLineItemEvent(Object source, String eventType, OrderLineItem orderItem) {
		super(source);
		this.eventType = eventType;
		this.orderItem = orderItem;
	}
	@Override
	public String toString() {
		return "OrderLineItemEvent [eventType=" + eventType + ", orderItem=" + orderItem + "]";
	}
	
}
