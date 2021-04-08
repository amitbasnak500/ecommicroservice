package com.ecommerce.order.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ecommerce.order.dao.OrderDaoRepository;
import com.ecommerce.order.model.Order;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class OrderRepositoryTest 
{
	
	@Autowired
	OrderDaoRepository orderDaoRepository;
	Order order;
	
	@BeforeEach
    public void setUp() 
	{
		order = new Order();
		order.setId(111);
		order.setId(1345);
		order.setOrderNumber("1234");
		order.setOrderTotal(678.34);
		order.setOrderTrackingNumber("99");
    }
	
	@AfterEach
	public void tearDown()
	{
		orderDaoRepository.deleteAll();
		order = null;
	}
	
	@Test
	public void givenOrderToAddShouldReturnAddedOrder()
	{
		orderDaoRepository.save(order);
	    Order fetchedOrder = orderDaoRepository.findById(order.getId()).get();
	    assertEquals(111, fetchedOrder.getId());
	}

	@Test
	public void givenIdTODeleteThenShouldDeleteTheOrder()
	{
		orderDaoRepository.save(order);
		orderDaoRepository.deleteById(order.getId());
	    Optional optional = orderDaoRepository.findById(order.getId());
	    assertEquals(Optional.empty(), optional);
	}

}
