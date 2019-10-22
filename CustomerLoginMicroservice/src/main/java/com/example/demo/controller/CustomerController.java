package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.LoginModel;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired CustomerService customerService;
	
	
	@PostMapping("/register")
	public List<String> createCustomer(@RequestBody Customer c){
		List<String> cid=new ArrayList<>();
		String status=customerService.createCustomer(c);
		if(status==null) {
			cid.add("userexist");
		}
		cid.add(status);
		return cid;
	}
	
	@PostMapping("/login")
	public List<String> loginCustomer(@RequestBody LoginModel request){
		String cemail=request.getEmail();
		System.out.println(cemail);
		List<String> cid=new ArrayList<>();
		String cpass = request.getPassword();
		List<Customer> customerlist = customerService.verifyUser(cemail,cpass);
		if(customerlist!=null) {
		for(Customer c:customerlist) {
			System.out.println("entered !!!!!!");
			cid.add(c.getCustomerid());
			return cid;
		}
		}
		System.out.println("got out!!");
		cid.add("wrongcredentials");
		return cid;
	}
	
	@RequestMapping("/findcustomer")
	public List<Customer> findbycid(@RequestParam("cid") String cid) {
		List<Customer> customer=customerService.findbycid(cid);
		return customer;
	}
	
	@RequestMapping("/findbyemail")
	public List<Customer> findbyemail(@RequestParam("email") String email){
		List<Customer> customer=customerService.findbyemail(email);
		return customer;
	}
	
	@RequestMapping("/changepassword")
	public void changepassword(@RequestParam("email") String email, @RequestParam("pass") String pass) {
		System.out.println("change paswoord controller");
		customerService.changepassword(email, pass);
	}
	
}
