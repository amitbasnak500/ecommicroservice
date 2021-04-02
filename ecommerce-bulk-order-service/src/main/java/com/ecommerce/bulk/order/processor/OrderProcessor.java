/**
 * 
 */
package com.ecommerce.bulk.order.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import com.ecommerce.bulk.order.model.Order;

/**
 * @author amit.basnak
 *
 */
@Slf4j
public class OrderProcessor implements ItemProcessor<Order, Order>
{

	@Override
	public Order process(Order order) throws Exception 
	{
		Order processedOrder = new Order();
		processedOrder.setAccount(order.getAccount());
		processedOrder.setBillingAddress(order.getBillingAddress());
		processedOrder.setShippingAddress(order.getShippingAddress());
		processedOrder.setOrderItems(order.getOrderItems());
		processedOrder.setOrderNumber(order.getOrderNumber());
		processedOrder.setOrderTotal(order.getOrderTotal());
		processedOrder.setOrderTrackingNumber(order.getOrderTrackingNumber());
		processedOrder.setOrderDate(order.getOrderDate());
		return processedOrder;
	}

}
