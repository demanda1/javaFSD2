package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.InvoiceRequest;
import com.example.demo.dto.MailRequest;
import com.example.demo.dto.ResetPasswordRequest;
import com.example.demo.entity.Customer;
import com.example.demo.entity.LoginModel;
import com.example.demo.entity.MyCart;
import com.example.demo.entity.Product;
import com.example.demo.entity.PaymentDetail;
import com.example.demo.service.CustomerLoginService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.EmailService;
import com.example.demo.service.PaymentService;
import com.example.demo.service.RenterService;

@RestController
public class HomeController {
	@Autowired CustomerService customerService;
	@Autowired CustomerLoginService customerLoginService;
	@Autowired RenterService renterService;
	@Autowired EmailService emailservice;
	@Autowired PaymentService paymentservice;
	@RequestMapping("/")
	public String selectCity() {
		return "select-city";
	}
	
	@RequestMapping("/showallproduct")
	public List<Product> showProductByCity(@RequestParam("city") String city,Model theModel){
		List<Product> productlist=renterService.showProductByCity(city, theModel);
		for(Product p:productlist) {
			System.out.println(p.getProductname());
		}
//		theModel.addAttribute("productlist",productlist);
		return productlist;
	}
	
	@RequestMapping("/showproductbyid")
	public List<Product> showProductByid(@RequestParam("pid") String pid,Model theModel){
		List<Product> productlist=renterService.showProductByid(pid,theModel);
		for(Product p:productlist) {
			System.out.println(p.getProductname());
		}
//		theModel.addAttribute("productlist",productlist);
		return productlist;
	}
	
	@RequestMapping("/showproduct") 
	public List<Product> showProduct(@RequestParam("category") String category, @RequestParam("city") String city, Model theModel){
		System.out.println("inside feign of renter");
		List<Product> productlist=renterService.showProduct(category,city);
		//theModel.addAttribute("productlist",productlist);
		for(Product p:productlist) {
			System.out.println(p.getProductname());
		}
		return productlist;
	}
	
	@RequestMapping("/createproduct/{renterid}/{category}/{city}")
	public void createProduct(@PathVariable String renterid,@PathVariable String category,@PathVariable String city, @RequestBody Product p) {
		renterService.createProduct(renterid, category, city, p);
		
	}
	
	@RequestMapping("/deleteproduct/{pid}")
	public void deleteProduct(@PathVariable String pid) {
		renterService.deleteProduct(pid);
	}
	
	@RequestMapping("/updateproduct/{name}/{pid}")
	public void updateProduct(@PathVariable String name, @PathVariable String pid) {
		renterService.updateProduct(name,pid);
	}
	
	@RequestMapping("/deleterenter/{sid}")
	public void deleteRenter(@PathVariable String sid) {
		renterService.deleteRenter(sid);
	}
	
	@RequestMapping("/mycart/{pid}/{cid}")
	public List<String> addToCart(@PathVariable String pid,@PathVariable String cid) {
		List<String> status=customerService.addToCart(pid, cid);
		System.out.println(status);
		return status;
	}
	
	@RequestMapping("/savecart/{cid}/{pid}/{quantity}")
	public List<String> saveCart(@PathVariable String cid,@PathVariable String pid, @PathVariable String quantity) {
		List<String> s= new ArrayList<>();
		s=customerService.saveCart(cid, pid, quantity);
		return s;
	}
	@RequestMapping("/checkout")
	public List<String> orderProduct(@RequestParam String cid, @RequestParam String status) {
		if(status.equals("success")) {
			return customerService.orderProduct(cid, status);
		}
		else {
			return null;
		}
		
	}
	
	@PostMapping("/register")
	public List<String> createCustomer(@RequestBody Customer c){
		List<String> cid=new ArrayList<>();
		cid=customerLoginService.createCustomer(c);
		return cid;
	}
	
	@PostMapping("/login")
	public List<String> loginCustomer(@RequestBody LoginModel request){
		List<String> status = customerLoginService.loginCustomer(request);
		return status;
	}
	
	
	//EMAIL Service client Calls
	@Autowired
	private EmailService service;

	@PostMapping("/sendotp")
	public ResponseEntity<?> sendEmail(@RequestBody MailRequest request) {
		Object result = service.sendEmail(request);
		return ResponseEntity.ok(result);
		
	}
	
	
	@PostMapping("/otpverified")
	public List<String> resendotp(@RequestBody MailRequest request) {
		return  service.resendotp(request);
	}
	
	@RequestMapping("/findcustomer")
	public List<Customer> findbycid(@RequestParam("cid") String cid) {
		List<Customer> customer=customerLoginService.findbycid(cid);
		return customer;
	}
	
	@RequestMapping("/viewcart")
	public List<Product> viewCart(@RequestParam("cid") String cid) {
		List<Product> productlist=customerService.viewCart(cid);
		return productlist;
	}
	
	@RequestMapping("/seecart")
	public List<MyCart> seeCart(@RequestParam("cid") String cid) {
		List<MyCart> cartlist=customerService.seeCart(cid);
		return cartlist;
	}
	
	@RequestMapping("/deleteitem")
	public void deleteProduct(@RequestParam("pid") String pid, @RequestParam("cid") String cid) {
		customerService.deleteProduct(pid, cid);
	}
	
	@RequestMapping("/findbyemail")
	public List<Customer> findbyemail(@RequestParam("email") String email){
		List<Customer> customer=customerLoginService.findbyemail(email);
		return customer;
	}
	
	@RequestMapping("/setidproof")
	public void setidproof(@RequestParam("idnum") String idnum, @RequestParam("cid") String cid) {
		customerService.setidproof(idnum, cid);
	}
	
	@RequestMapping("/walletpayment")
	public List<String> walletpayment(@RequestParam("cid") String cid, @RequestParam("amount") String amount){
		return (customerService.walletpayment(cid, amount));
	}
	
	@PostMapping("/resetpassword")
	public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request){
		return emailservice.resetPassword(request);
		
	}
	
	@RequestMapping("/changepassword")
	public void changepassword(@RequestParam("email") String email, @RequestParam("pass") String pass) {
		customerLoginService.changepassword(email, pass);
	}
	
	@PostMapping("/sendinvoice")
	public ResponseEntity<?> sendInvoice(@RequestBody InvoiceRequest request){
		return emailservice.sendInvoice(request);
		 
	}
	
	 @PostMapping(path = "/payment-details")
	    public @ResponseBody PaymentDetail proceedPayment(@RequestBody PaymentDetail paymentDetail){
	        return paymentservice.proceedPayment(paymentDetail);
	    }
	
	
	
}
