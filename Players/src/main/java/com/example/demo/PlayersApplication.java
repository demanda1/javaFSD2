package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.entity.Player;
import com.example.demo.repo.PlayerRepo;

@SpringBootApplication
@EnableDiscoveryClient
public class PlayersApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PlayersApplication.class, args);
	}

}
