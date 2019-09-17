package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ResponseModel;
import com.example.demo.service.PlayerService;

@RestController("/")
public class PLayerController {
    @Autowired
	private PlayerService pservice;
	
	@RequestMapping("/findbysports")
	private List<ResponseModel> findBySports(@RequestParam("sport") String sports){
		System.out.println(sports);
		List<ResponseModel> myplayers=pservice.getPlayers(sports);
		return myplayers;
	}
	
}
