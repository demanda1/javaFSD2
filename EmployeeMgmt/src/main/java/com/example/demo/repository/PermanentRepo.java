package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Permanent;
@Repository
public interface PermanentRepo extends CrudRepository<Permanent, Integer> {

}
