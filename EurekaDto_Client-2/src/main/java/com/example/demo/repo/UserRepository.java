package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

	  List<UserEntity> findByEmail(String email);
	  List<UserEntity> findByFirstnameAndPassword(String firstname,String password);
}
