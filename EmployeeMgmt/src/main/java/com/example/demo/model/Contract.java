package com.example.demo.model;

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
	public Contract(String firstname, String lastname, String email,int hPaid, String cPeriod) {
		super(firstname,lastname,email);
		this.hPaid = hPaid;
		this.cPeriod = cPeriod;
	}
	public int gethPaid() {
		return hPaid;
	}
	public void sethPaid(int hPaid) {
		this.hPaid = hPaid;
	}
	public String getcPeriod() {
		return cPeriod;
	}
	public void setcPeriod(String cPeriod) {
		this.cPeriod = cPeriod;
	}
	
	
}
