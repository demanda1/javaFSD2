package com.example.demo.model;

public class ResponseModel {
	private String name;
	private String sports;
	private int age;
	private int weight;
	private String gender;
	
	public ResponseModel() {
		super();
	}
	public ResponseModel(String name, String sports, int age, int weight,String gender) {
		super();
		this.name = name;
		this.sports = sports;
		this.age = age;
		this.weight = weight;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSports() {
		return sports;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
