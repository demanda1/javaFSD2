package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rId;
	@Column(name="rPrepTime")
	private String rPrepTime;
	@Column(name="rcookTime")
	private String rCookTime;
	@Column(name="rDescripton")
	private String eDescription;
	@Column(name="rDifficulty")
	private String rDifficulty;
	@Column(name="rDirections")
	private String rDirections;
	@Column(name="rServings")
	private String rServings;
	@Column(name="rSource")
	private String rSource;

	public Recipe() {
		super();
	}
	public Recipe(String rPrepTime, String rCookTime, String eDescription, String rDifficulty, String rDirections,
			String rServings, String rSource) {
		super();
		this.rPrepTime = rPrepTime;
		this.rCookTime = rCookTime;
		this.eDescription = eDescription;
		this.rDifficulty = rDifficulty;
		this.rDirections = rDirections;
		this.rServings = rServings;
		this.rSource = rSource;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrPrepTime() {
		return rPrepTime;
	}
	public void setrPrepTime(String rPrepTime) {
		this.rPrepTime = rPrepTime;
	}
	public String getrCookTime() {
		return rCookTime;
	}
	public void setrCookTime(String rCookTime) {
		this.rCookTime = rCookTime;
	}
	public String geteDescription() {
		return eDescription;
	}
	public void seteDescription(String eDescription) {
		this.eDescription = eDescription;
	}
	public String getrDifficulty() {
		return rDifficulty;
	}
	public void setrDifficulty(String rDifficulty) {
		this.rDifficulty = rDifficulty;
	}
	public String getrDirections() {
		return rDirections;
	}
	public void setrDirections(String rDirections) {
		this.rDirections = rDirections;
	}
	public String getrServings() {
		return rServings;
	}
	public void setrServings(String rServings) {
		this.rServings = rServings;
	}
	public String getrSource() {
		return rSource;
	}
	public void setrSource(String rSource) {
		this.rSource = rSource;
	}
	@Override
	public String toString() {
		return "Recipe [rId=" + rId + ", rPrepTime=" + rPrepTime + ", rCookTime=" + rCookTime + ", eDescription="
				+ eDescription + ", rDifficulty=" + rDifficulty + ", rDirections=" + rDirections + ", rServings="
				+ rServings + ", rSource=" + rSource + "]";
	}
	
	
}
