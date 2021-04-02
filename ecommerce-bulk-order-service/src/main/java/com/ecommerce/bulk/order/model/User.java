package com.ecommerce.bulk.order.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="USER_NAME", nullable = false)
	private String userName;
	
	@Column(name ="FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name ="LAST_NAME", nullable = false)
	private String lastName;
	
	private String sex;
	
	@Column(name ="MEMBER_TYPE", nullable = false)
	private String memberType;
	
	@Column(name ="ACCOUNT_NUMBER", nullable = false)
	private String accountNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name ="REGISTRATION_DATE", nullable = false, unique = false, length = 10)
	private Date registrationDate;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
