package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.demo.data.Gallary;
@RestController
@RequestMapping("/")
public class GallaryController {
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/gallary")
	public Gallary getImages() {
		Gallary g=new Gallary();
		g.setId(1);
		
		List<Object> imageList=restTemplate.getForObject("http://MyImageService/images", List.class);
		
		g.setList(imageList);
		return g;
	}
}
