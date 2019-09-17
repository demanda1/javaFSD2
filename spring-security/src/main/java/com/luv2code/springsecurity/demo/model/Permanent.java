package com.luv2code.springsecurity.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Permanent")
public class Permanent {

	private int salary;
	private float commision;
}
