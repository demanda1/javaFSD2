package com.example.demo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Players")
public interface PlayerClientService {

	@RequestMapping(value="/findbysports" , method=RequestMethod.GET)
	public List<PlayerResponseModel> getPlayers(@RequestParam("sport") String sports);
}
