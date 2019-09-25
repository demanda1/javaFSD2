package com.example.demo.repository;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.User;
import java.lang.String;

@Repository
public interface UserRepository extends JpaRepository<Customer,Integer>{

	List<Customer> findByCustomerId(String cid);
	
	Optional<User> findByUserId(String userId);

	User findByEmail(String email);

	@Transactional
	void deleteByUserId(String userId);
	
}
