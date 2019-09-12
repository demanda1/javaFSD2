package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Notes;
@Repository
public interface NotesRepo extends CrudRepository<Notes, Integer> {

}
