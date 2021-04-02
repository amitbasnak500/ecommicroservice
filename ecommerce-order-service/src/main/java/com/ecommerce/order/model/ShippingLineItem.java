package com.ecommerce.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SHIPPING_ITEMS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingLineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="PRODUCT_ID", nullable = false)
	private Long productId;
	
	@Column(name ="QTY_SHIPPED", nullable = false)
	private int quantityShipped;
	
	@Column(name ="UNIT_PRICE", nullable = false)
	private Double unitPrice;
	
	@Column(name ="UOM", nullable = false)
	private String uom;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHIPPING_ID", nullable = false)
	Shipping shipment;
	
}
