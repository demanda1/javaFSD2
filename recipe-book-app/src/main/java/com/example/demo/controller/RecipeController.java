package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Ingredients;
import com.example.demo.model.Notes;
import com.example.demo.model.Recipe;
import com.example.demo.repository.IngredientsRepo;
import com.example.demo.repository.MenuRepo;
import com.example.demo.repository.NotesRepo;
import com.example.demo.repository.RecipeRepo;

@Controller
public class RecipeController {

	private IngredientsRepo ingredientsrepo;
	private MenuRepo menurepo;
	private NotesRepo notesrepo;
	private RecipeRepo reciperepo;
	
	public RecipeController(IngredientsRepo ingredientsrepo, MenuRepo menurepo, NotesRepo notesrepo,
			RecipeRepo reciperepo) {
		super();
		this.ingredientsrepo = ingredientsrepo;
		this.menurepo = menurepo;
		this.notesrepo = notesrepo;
		this.reciperepo = reciperepo;
	}

	@RequestMapping("/")
	public String demo(Model theModel) {
		theModel.addAttribute("menu",menurepo.findAll());
		return "main-menu";
	}
	
	@GetMapping("viewdetails/{recipe}/{ingredients}/{notes}")
	public String view(@PathVariable("recipe") String recipe ,@PathVariable("ingredients") String ingredients ,@PathVariable("notes") String notes , Model theModel) {
		System.out.println(recipe);
		System.out.println(ingredients);
		System.out.println(notes);
		Optional<Recipe> r = reciperepo.findById(Integer.parseInt(recipe));
		Optional<Ingredients> i = ingredientsrepo.findById(Integer.parseInt(ingredients));
		Optional<Notes> n= notesrepo.findById(Integer.parseInt(notes));
		theModel.addAttribute("recipe",r.get());
		theModel.addAttribute("ingredients",i.get());
		theModel.addAttribute("notes",n.get());
		return "details";
	}
	
}
