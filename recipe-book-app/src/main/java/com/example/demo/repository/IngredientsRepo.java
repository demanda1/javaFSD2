package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ingredients;
@Repository
public interface IngredientsRepo extends CrudRepository<Ingredients, Integer> {

}
