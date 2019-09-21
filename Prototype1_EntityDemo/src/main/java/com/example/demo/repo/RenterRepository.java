package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Renter;

@Repository
public interface RenterRepository extends JpaRepository<Renter, Integer> {

	List<Renter> findBySellerid(String sellerid);
	void deleteBySellerid(String sellerid);
}
