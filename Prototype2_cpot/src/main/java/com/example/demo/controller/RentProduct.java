package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.ProductRepository;
import com.example.demo.services.ProductService;

@RestController
public class RentProduct {
	@Autowired ProductRepository productrepo;
	@Autowired ProductService productservice;
	
	@RequestMapping("/mycart/{pid}/{cid}")
	public void addToCart(@PathVariable String pid,@PathVariable String cid) {
		String status=productservice.addToCart(pid, cid);
		System.out.println(status);
	}
	@RequestMapping("/checkout/{status}/{cid}")
	public String orderProduct(@PathVariable String cid, @PathVariable String status) {
		if(status.equals("success")) {
			return productservice.orderProduct(cid);
		}
		else {
			return null;
		}
		
	}
}
