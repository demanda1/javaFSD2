package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.services.ProductServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class HomeController {

	@Autowired ProductServices productServices;
	
	@RequestMapping("/")
	public String selectCity() {
		return "select-city";
	}
	
	@RequestMapping("/showallproduct")
	public String showProductByCity(@RequestParam("city") String city,Model theModel){
		List<Product> productlist=productServices.showProductByCity(city);
		theModel.addAttribute("productlist",productlist);
		return "show-product";
	}
	
	@RequestMapping("/showproduct/{category}")
	public String showProduct(@PathVariable String category, Model theModel){
		List<Product> productlist=productServices.showProduct(category);
		//theModel.addAttribute("productlist",productlist);
		for(Product p:productlist) {
			System.out.println(p.toString());
		}
		return productlist.toString();
	}
	
	@RequestMapping("/createproduct/{id}/{category}/{city}")
	public void createProduct(@PathVariable String id,@PathVariable String category,@PathVariable String city, @RequestBody Product p) {
		productServices.createProduct(p, id, category, city);
		
	}
	
	@RequestMapping("/deleteproduct/{pid}")
	public void deleteProduct(@PathVariable String pid) {
		productServices.deleteProduct(pid);
	}
	
	@RequestMapping("/updateproduct/{name}/{pid}")
	public void updateProduct(@PathVariable String name, @PathVariable String pid) {
		productServices.updateProduct(name,pid);
	}
	
	@RequestMapping("/deleterenter/{sid}")
	public void deleteRenter(@PathVariable String sid) {
		productServices.deleteRenter(sid);
	}
	
}
