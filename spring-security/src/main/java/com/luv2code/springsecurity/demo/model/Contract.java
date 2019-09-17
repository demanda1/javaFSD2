package com.luv2code.springsecurity.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Contract")
public class Contract extends Employee {

	private int hPaid;
	private String cPeriod;
	public Contract() {
		super();
	}
	public Contract(int hPaid, String cPeriod) {
		super();
		this.hPaid = hPaid;
		this.cPeriod = cPeriod;
	}
	
	
}
