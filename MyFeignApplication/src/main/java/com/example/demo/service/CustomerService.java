 package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.MyCart;
import com.example.demo.entity.Product;

@FeignClient(name="CustomerMicroservice")
public interface CustomerService {
	
	@RequestMapping(value="/mycart/{pid}/{cid}",  method=RequestMethod.GET)
	public List<String> addToCart(@PathVariable String pid,@PathVariable String cid);
	
	@RequestMapping(value="/savecart/{cid}/{pid}/{quantity}",  method=RequestMethod.GET)
	public List<String> saveCart(@PathVariable String cid,@PathVariable String pid, @PathVariable String quantity);
	@RequestMapping(value="/checkout",  method=RequestMethod.GET)
	public List<String> orderProduct(@RequestParam String cid, @RequestParam String status);
	@RequestMapping("/viewcart")
	public List<Product> viewCart(@RequestParam("cid") String cid);
	
	@RequestMapping("/deleteitem")
	public void deleteProduct(@RequestParam("pid") String pid, @RequestParam("cid") String cid);
	
	@RequestMapping("/setidproof")
	public void setidproof(@RequestParam("idnum") String idnum, @RequestParam("cid") String cid);
	
	@RequestMapping("/walletpayment")
	public List<String> walletpayment(@RequestParam("cid") String cid, @RequestParam("amount") String amount);
	
	@RequestMapping("/seecart")
	public List<MyCart> seeCart(@RequestParam("cid") String cid);
}
