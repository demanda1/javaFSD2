package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Ingredients {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int iId;
	@Column(name="iAmount")
	private String iAmount;
	@Column(name="iDescription")
	@Lob
	private String iDescription;
	@Column(name="iRecipeId")
	private String iRecipeId;
   
	public Ingredients() {
		super();
	}
	public Ingredients(String iAmount, String iDescription, String iRecipeId) {
		super();
		this.iAmount = iAmount;
		this.iDescription = iDescription;
		this.iRecipeId = iRecipeId;
	}
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public String getiAmount() {
		return iAmount;
	}
	public void setiAamount(String iAamount) {
		this.iAmount = iAmount;
	}
	public String getiDescription() {
		return iDescription;
	}
	public void setiDescription(String iDescription) {
		this.iDescription = iDescription;
	}
	public String getiRecipeId() {
		return iRecipeId;
	}
	public void setiRecipeId(String iRecipeId) {
		this.iRecipeId = iRecipeId;
	}
	
}
