package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Integer>{

	public List<Player> findBySports(String sport);
}
