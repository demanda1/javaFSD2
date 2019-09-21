package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.services.ProductServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class HomeController {

	@Autowired ProductServices productServices;
	@RequestMapping("/showproduct/{category}")
	public String showProduct(@PathVariable String category, Model theModel){
		List<Product> productlist=productServices.showProduct(category);
		//theModel.addAttribute("productlist",productlist);
		for(Product p:productlist) {
			System.out.println(p.toString());
		}
		return productlist.toString();
	}
	
	@RequestMapping("/createproduct/{id}/{category}")
	public void createProduct(@PathVariable String id,@PathVariable String category, @RequestBody Product p) {
		productServices.createProduct(p, id, category);
		
	}
	
	@RequestMapping("/deleteproduct/{pid}/{sid}")
	public void deleteProduct(@PathVariable String pid, @PathVariable String sid) {
		productServices.deleteProduct(pid,sid);
	}
	
	@RequestMapping("/updateproduct/{name}/{pid}")
	public void updateProduct(@PathVariable String name, @PathVariable String pid) {
		productServices.updateProduct(name,pid);
	}
	
}
