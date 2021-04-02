package com.ecommerce.order.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SHIPPING")
public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="OFFER_ID", nullable = false)
	private Long offerId;
	
	@Column(name ="IS_AVAILABLE", nullable = false)
	private boolean isAvailable;
	
	@Temporal(TemporalType.DATE)
	@Column(name ="ARRIVAL_DATE", nullable = false, unique = false, length = 10)
	private Date arrivalDate;
	
	@Column(name ="IS_FREE", nullable = false)
	private boolean isFree;
	
	@Column(name ="DAYS-IN_TRANSIT", nullable = false)
	private int daysInTransit;
	
	@Column(name ="SHIPPING_CHARGE", nullable = false)
	private Double shippingCharge;
	
	@Column(name ="IS_FREE_FOR_MEMBERS", nullable = false)
	private boolean isFreeForMembers;
	
	@Column(name ="SHIPPING_MODE", nullable = false)
	private String shippingMode;
	
	@Column(name ="SHIPPING_CARRIER", nullable = false)
	private String shipCarrier;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID", nullable = false)
	private Order order;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment", cascade = CascadeType.ALL)
	private Set<ShippingLineItem> shippingItems = new HashSet<ShippingLineItem>();
	
}
