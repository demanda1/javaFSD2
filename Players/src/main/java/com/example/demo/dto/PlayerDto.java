package com.example.demo.dto;

public class PlayerDto {

	private String pName;
	private String pSports;
	private int pAge;
	private int pWeight;
	private String pGender;
	
	public PlayerDto() {
		super();
	}
	public PlayerDto(String pName, String pSports, int pAge, int pWeight, String pGender) {
		super();
		this.pName = pName;
		this.pSports = pSports;
		this.pAge = pAge;
		this.pWeight = pWeight;
		this.pGender = pGender;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpSports() {
		return pSports;
	}
	public void setpSports(String pSports) {
		this.pSports = pSports;
	}
	public int getpAge() {
		return pAge;
	}
	public void setpAge(int pAge) {
		this.pAge = pAge;
	}
	public int getpWeight() {
		return pWeight;
	}
	public void setpWeight(int pWeight) {
		this.pWeight = pWeight;
	}
	public String getpGender() {
		return pGender;
	}
	public void setpGender(String pGender) {
		this.pGender = pGender;
	}
	
	
}
