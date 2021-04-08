package com.ecommerce.order.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.order.dao.OrderDaoRepository;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.OrderService;
import com.ecommerce.order.service.OrderServiceImpl;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
	
	@Mock
	private OrderDaoRepository orderDaoRepository;
	
	@Autowired
    @InjectMocks
    private OrderServiceImpl orderServiceImpl;
	private Order order;
	List<Order>orderList;
	
    
	@BeforeEach
	void setUp() throws Exception 
	{
		order = new Order();
		order.setId(111);
		order.setId(1345);
		order.setOrderNumber("1234");
		order.setOrderTotal(678.34);
		order.setOrderTrackingNumber("99");
		orderList.add(order);
	}
	
	@Test
	void givenOrdertToAddShouldReturnAddedOrder() 
	{
	    orderServiceImpl.save(order);
	    verify(orderDaoRepository,times(1)).save(any());
	}
	
	@AfterEach
	void tearDown() throws Exception
	{
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
