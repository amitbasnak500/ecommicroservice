package com.ecommerce.order.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "ORDER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="ORDER_NUMBER", nullable = false)
	private String orderNumber;
	
	@Column(name ="ORDER_TRACKING_NUMBER", nullable = false)
	private String orderTrackingNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name ="ORDER_DATE", nullable = false, unique = false, length = 10)
	private Date orderDate;
	
	@Column(name ="ORDER_TOTAL", nullable = false)
	private Double orderTotal;
	
	@OneToOne
	@JoinColumn(name = "USER_PROFILE_ID")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "SHIPPING_ADDRESS_ID")
	private Address shippingAddress;
	
	@OneToOne
	@JoinColumn(name = "BILLING_ADDRESS_ID")
	private Address billingAddress;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private Set<OrderLineItem> orderItems  = new HashSet<OrderLineItem>();
	
}
