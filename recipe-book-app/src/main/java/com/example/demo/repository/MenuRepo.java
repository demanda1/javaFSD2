package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Menu;

@Repository
public interface MenuRepo extends CrudRepository<Menu, Integer> {

}
