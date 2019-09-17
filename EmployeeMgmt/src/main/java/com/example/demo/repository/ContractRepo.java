package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Contract;


@Repository
public interface ContractRepo extends CrudRepository<Contract, Integer> {

}
