package com.ecommerce.pricing.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRICING")
public class Pricing
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="PRODUCT_CODE", nullable = false)
	private String productCode;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "PAYMENT_METHOD", nullable = false)
	private PaymentMethod paymentMethod;
	
	@Column(name ="ORIG_PRICE", nullable = false)
	private Double originalPrice;

	@Column(name ="DISC_PRICE", nullable = false)
	private Double discountedPrice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(discountedPrice, id, originalPrice, paymentMethod, productCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pricing other = (Pricing) obj;
		return Objects.equals(discountedPrice, other.discountedPrice) && id == other.id
				&& Objects.equals(originalPrice, other.originalPrice) && paymentMethod == other.paymentMethod
				&& Objects.equals(productCode, other.productCode);
	}

	@Override
	public String toString() {
		return "Pricing [id=" + id + ", productCode=" + productCode + ", paymentMethod=" + paymentMethod
				+ ", originalPrice=" + originalPrice + ", discountedPrice=" + discountedPrice + "]";
	}

	public Pricing(long id, String productCode, @NotNull PaymentMethod paymentMethod, Double originalPrice,
			Double discountedPrice) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.paymentMethod = paymentMethod;
		this.originalPrice = originalPrice;
		this.discountedPrice = discountedPrice;
	}

	public Pricing()
	{
		
	}
}
