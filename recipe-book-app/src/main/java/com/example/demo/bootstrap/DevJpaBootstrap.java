package com.example.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.model.Ingredients;
import com.example.demo.model.Menu;
import com.example.demo.model.Notes;
import com.example.demo.model.Recipe;
import com.example.demo.repository.IngredientsRepo;
import com.example.demo.repository.MenuRepo;
import com.example.demo.repository.NotesRepo;
import com.example.demo.repository.RecipeRepo;

@Component
public class DevJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private IngredientsRepo ingredientsrepo;
	private MenuRepo menurepo;
	private NotesRepo notesrepo;
	private RecipeRepo reciperepo;
	
	public DevJpaBootstrap(IngredientsRepo ingredientsrepo, MenuRepo menurepo, NotesRepo notesrepo,
			RecipeRepo reciperepo) {
		super();
		this.ingredientsrepo = ingredientsrepo;
		this.menurepo = menurepo;
		this.notesrepo = notesrepo;
		this.reciperepo = reciperepo;
	}



	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		init();
	}



	private void init() {
		// TODO Auto-generated method stub
		String desc1="10 baby corn, chopped\r\n" + 
				"½ cup maida / plain flour / all-purpose flour\r\n" + 
				"2 tbsp corn flour\r\n" + 
				"½ tsp ginger-garlic paste\r\n" + 
				"1 tsp kashmiri chilli powder\r\n" + 
				"salt to taste\r\n" + 
				"½ cup water, add as required\r\n" + 
				"oil for deep frying\r\n" + 
				"OTHER INGREDIENTS:\r\n" + 
				"2 tsp oil\r\n" + 
				"½ onion, finely chopped\r\n" + 
				"1 spring onion, chopped1\r\n" + 
				"1 inch ginger, finely chopped\r\n" + 
				"2 cloves garlic, finely chopped\r\n" + 
				"1 tbsp chilli sauce\r\n" + 
				"2 tsp soy sauce / soya sauce\r\n" + 
				"2 tsp vinegar\r\n" + 
				"salt to taste\r\n" + 
				"½ cup tomato sauce\r\n" + 
				"½ tsp pepper, crushed" ;
		String instruction1="INSTRUCTIONS\r\n" + 
				"BATTER RECIPE:\r\n" + 
				"firstly, in a large mixing bowl take maida and corn flour.\r\n" + 
				"also add ginger-garlic paste, chilli powder and salt.\r\n" + 
				"now slowly add water as required.\r\n" + 
				"and make a smooth flowing consistency batter.\r\n" + 
				"furthermore, add chopped baby corn and coat well with batter.\r\n" + 
				"then deep fry into hot oil till they turn golden brown.\r\n" + 
				"dip each cooked gobi florets into the batter.\r\n" + 
				"finally, drain the fried baby corn on a kitchen paper towel to remove excess oil.\r\n" + 
				"BABY CORN MANCHURI RECIPE:\r\n" + 
				"firstly, in a large kadai add 2 tsp oil\r\n" + 
				"furthermore, add chopped onion, spring onions, ginger and garlic. saute for a minute.\r\n" + 
				"add chilli sauce, soya sauce, vinegar, salt and tomato sauce.\r\n" + 
				"mix well till the sauce turns slightly thick.\r\n" + 
				"now add the deep fried baby corns\r\n" + 
				"also add black pepper powder and give a good mix.\r\n" + 
				"finally, add some chopped spring onions greens and serve hot.";
		Ingredients ingredients=new Ingredients("100",desc1,"1");
		Notes notes=new Notes("Serve it warm",1);
		Recipe recipe=new Recipe("10 min","10 min",instruction1, "easy","make crispy","3 servings","chopstix.com");
		Menu menu =new Menu("Babycorn Munchurian",recipe,notes,ingredients);
		ingredientsrepo.save(ingredients);
		reciperepo.save(recipe);
		notesrepo.save(notes);
		menurepo.save(menu);
		
	}

}
