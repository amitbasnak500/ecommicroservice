package com.ecommerce.order.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.ecommerce.order.model.OrderLineItem;

public interface OrderLineItemDaoRepository extends PagingAndSortingRepository<OrderLineItem, Long>
{

	
}
