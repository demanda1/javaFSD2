package com.example.demo.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Player;
import com.example.demo.model.ResponseModel;
import com.example.demo.repo.PlayerRepo;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepo playerrepo;
	private List<ResponseModel> rmList;
	public List<ResponseModel> getPlayers(String sport){
		System.out.println("***inside the player service!!!!!");
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		System.out.println("TEST STARTS..!1");
		List<Player> pList=playerrepo.findBySports(sport);
		System.out.println("TEST endding");
		Type listType = new TypeToken<List<ResponseModel>>() {}.getType();
		rmList=mapper.map(pList,listType);
		return rmList;
	};
}
