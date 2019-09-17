package com.example.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Permanent")
public class Permanent extends Employee {

	private int salary;
	private double commision;
	
	public Permanent(String firstname, String lastname, String email, int salary, double commision) {
		// TODO Auto-generated constructor stub
		super(firstname,lastname,email);
		this.salary=salary;
		this.commision=commision;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public double getCommision() {
		return commision;
	}
	public Permanent() {
		super();
	}
	public void setCommision(float commision) {
		this.commision = commision;
	}
	
	
	
}
