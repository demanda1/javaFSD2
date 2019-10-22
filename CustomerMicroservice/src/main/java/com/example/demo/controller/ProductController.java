package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MyCart;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
@RestController
public class ProductController {
	@Autowired ProductRepository productrepo;
	@Autowired ProductService productservice;
	
	@RequestMapping("/mycart/{pid}/{cid}")
	public List<String> addToCart(@PathVariable String pid,@PathVariable String cid) {
		String status=productservice.addToCart(pid, cid);
		List<String> cartlist=new ArrayList<>();
		cartlist.add(status);
		System.out.println(status);
		return cartlist;
	}
	
	@RequestMapping("/savecart/{cid}/{pid}/{quantity}")
	public List<String> saveCart(@PathVariable String cid,@PathVariable String pid, @PathVariable String quantity) {
		int q=Integer.parseInt(quantity);
		String status=productservice.saveCart(cid, pid, q);
		System.out.println(status);
		List<String> s=new ArrayList<>();
		s.add(status);
		return s;
	}
	@RequestMapping("/checkout")
	public List<String> orderProduct(@RequestParam String cid, @RequestParam String status) {
		List<String> ordertype=new ArrayList<>();
		if(status.equals("success")) {
			ordertype.add(productservice.orderProduct(cid));
			return ordertype;
		}
		else {
			return null;
		}
		
	}
	
	@RequestMapping("/deleteitem")
	public void deleteProduct(@RequestParam("pid") String pid, @RequestParam("cid") String cid) {
		System.out.println("controller of delete");
		productservice.deleteitem(pid, cid);
	}
	
	@RequestMapping("/viewcart")
	public List<Product> viewCart(@RequestParam("cid") String cid) {
		List<Product> productlist=productservice.viewcart(cid);
		return productlist;
	}
	
	@RequestMapping("/seecart")
	public List<MyCart> seeCart(@RequestParam("cid") String cid) {
		List<MyCart> cartlist=productservice.mycart(cid);
		return cartlist;
	}
	
	@RequestMapping("/setidproof")
	public void setidproof(@RequestParam("idnum") String idnum, @RequestParam("cid") String cid) {
		productservice.setidproof(idnum, cid);
	}
	
	@RequestMapping("/walletpayment")
	public List<String> walletpayment(@RequestParam("cid") String cid, @RequestParam("amount") String amount){
		List<String> status=new ArrayList<>();
		status.add(productservice.walletpayment(cid, amount));
		return status;
	}
	
}
