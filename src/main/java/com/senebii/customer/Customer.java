package com.senebii.customer;

import java.util.Date;

public class Customer {
	private int id;
	private Date joinDate;
	private CustomerType type;
	
	public Customer(int id, Date joinDate, CustomerType type) {
		this.id = id;
		this.joinDate = joinDate;
		this.type = type;
	}
	
	public Customer(int id, Date joinDate) {
		this(id, joinDate, CustomerType.REGULAR);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	
}
