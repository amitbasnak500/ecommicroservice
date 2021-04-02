package com.ecommerce.order.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.ecommerce.order.model.Shipping;

public interface ShippingDaoRepository extends PagingAndSortingRepository<Shipping, Long>
{
	
}
