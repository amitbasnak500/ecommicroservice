package com.ecommerce.bulk.order.model;

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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDER")
public class Order
{
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<OrderLineItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderLineItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	

}
