package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mId;
	@Column(name="mName")
	private String mName;
	@OneToOne
	@JoinColumn(name="recipeId")
	private Recipe recipe;
	@OneToOne
	@JoinColumn(name="notesId")
	private Notes notes;
	@OneToOne
	@JoinColumn(name="ingredientsId")
	private Ingredients ingredients;
	public Menu() {
		super();
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public Notes getNotes() {
		return notes;
	}
	public void setNotes(Notes notes) {
		this.notes = notes;
	}
	public Ingredients getIngredients() {
		return ingredients;
	}
	public void setIngredients(Ingredients ingredients) {
		this.ingredients = ingredients;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public Menu(String mName, Recipe recipe, Notes notes, Ingredients ingredients) {
		super();
		this.mName = mName;
		this.recipe = recipe;
		this.notes = notes;
		this.ingredients = ingredients;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	@Override
	public String toString() {
		return "Menu [mId=" + mId + ", mName=" + mName + "]";
	}
	
}
