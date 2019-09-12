package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Notes {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nId;
	@Column(name="nNotes")
	private String nNotes;
	@Column(name="nRecipeId")
	private int nRecipeId;

	public Notes() {
		super();
	}
	public Notes(String nNotes, int nRecipeId) {
		super();
		this.nNotes = nNotes;
		this.nRecipeId = nRecipeId;
	}
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	public String getnNotes() {
		return nNotes;
	}
	public void setnNotes(String nNotes) {
		this.nNotes = nNotes;
	}
	public int getnRecipeId() {
		return nRecipeId;
	}
	public void setnRecipeId(int nRecipeId) {
		this.nRecipeId = nRecipeId;
	}
	@Override
	public String toString() {
		return "Notes [nId=" + nId + ", nNotes=" + nNotes + ", nRecipeId=" + nRecipeId + "]";
	}
	
}
