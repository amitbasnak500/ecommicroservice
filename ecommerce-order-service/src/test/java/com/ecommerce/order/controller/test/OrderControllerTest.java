package com.ecommerce.order.controller.test;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ecommerce.order.controller.OrderController;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.OrderServiceImpl;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	@Autowired
    @Mock
    private OrderServiceImpl orderServiceImpl;
	private Order order;
	List<Order>orderList;
	
	@InjectMocks
	OrderController orderController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception
	{
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		order = null;
	}
	
	@Test
	public void PostMappingOfOrder() throws Exception
	{
	   when(orderServiceImpl.save(any())).thenReturn(order);
	   mockMvc.perform(post("/api/order").
	           contentType(MediaType.APPLICATION_JSON).
	           content(asJsonString(order))).
	           andExpect(status().isCreated());
	   verify(orderServiceImpl,times(1)).save(any());
	}

	
}
