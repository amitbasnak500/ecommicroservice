package com.ecommerce.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@SqlResultSetMapping(name = "addressPartialMapping", classes = {
		@ConstructorResult(targetClass = AddressDTO.class, columns  = {
				@ColumnResult(name = "id", type = Long.class),
				@ColumnResult(name = "house_number"),
				@ColumnResult(name = "street_address"),
				@ColumnResult(name = "city"),
				@ColumnResult(name = "state"),
				@ColumnResult(name = "zip_code"),
				@ColumnResult(name = "account_id", type = Long.class)
		})
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "AddressDaoRepository.getAddressByID",
			query = "SELECT id,city,house_number,state, street_address, zip_code, "
			+ "account_id FROM rollingstone_address a WHERE a.id = :id", resultSetMapping = "addressPartialMapping" )
})
@Entity
@Table(name = "ADDRESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="house_number", nullable = false)
	private String houseNumber;
	
	@Column(name="street_address", nullable = false)
	private String streetAddress;
	
	private String city;
	
	private String state;
	
	@Column(name="zip_code", nullable = false)
	private String zipCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name  = "ACCOUNT_ID", nullable = false)
	private Account account;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
