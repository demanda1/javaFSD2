package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {
    @Autowired
	private PlayerClientService pcs;
    @RequestMapping("/")
    public String home() {
    	return "myhome";
    }
	@RequestMapping("/fetch")
	public String getPlayer(@RequestParam("sport") String sports,Model theModel) {
		theModel.addAttribute("player",pcs.getPlayers(sports));
		List<PlayerResponseModel> list=pcs.getPlayers(sports);
		for(PlayerResponseModel p:list) {
			System.out.println(p.getName());
		}
		return "show-player";
	}
}
