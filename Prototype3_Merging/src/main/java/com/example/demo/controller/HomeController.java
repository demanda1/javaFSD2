package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.services.ProductServices;

import io.micrometer.core.ipc.http.HttpSender.Request;

@Controller
public class HomeController {

	@Autowired ProductServices productServices;
	
	@RequestMapping("/")
	public String selectCity() {
		return "select-city";
		
	}
	
	@RequestMapping("/showhomepage")
	public String myHomePage(@RequestParam("city") String city, Model theModel) {
		List<Product> productlist=productServices.showProductByCity(city);
		theModel.addAttribute("productlist",productlist);
		theModel.addAttribute("city",city);
		return "home-page";
	}
	
	@RequestMapping("/rentersproducts")
	public String renterProduct(@RequestParam("sid") String sid, Model theModel) {
		List<Product> rentersproduct=productServices.showRenterProduct(sid);
		for(Product p:rentersproduct) {
			System.out.println(p.getProductname());
		}
		theModel.addAttribute("rentersproducts",rentersproduct);
		theModel.addAttribute("sid",sid);
		return "renter-profile";
	}
	
	
	@RequestMapping("/rentersprofile")
	public String renterProfile(@RequestParam("sid") String sid, Model theModel) {
		List<Product> rentersproduct=productServices.showRenterProduct(sid);
		for(Product p:rentersproduct) {
			System.out.println(p.getProductname());
		}
		theModel.addAttribute("sid",sid);
		return "renter-profile";
	}
	
	

	@PostMapping("/createproduct")
	public String createProduct(HttpServletRequest request, Model theModel) {
		String sid=request.getParameter("sid");
		String pid=request.getParameter("pid");
		String productname=request.getParameter("productname");
		int productprice=Integer.parseInt(request.getParameter("productprice"));
		int productquantity=Integer.parseInt(request.getParameter("productquantity"));
		String category=request.getParameter("category");
		String city=request.getParameter("city");
		Product p=new Product(pid,productname,productprice ,productquantity);
		String msg=productServices.createProduct(p, sid, category, city);
		theModel.addAttribute("msg",msg);
		theModel.addAttribute("sid",sid);
		return "renter-profile";
	}
	
	@RequestMapping("/deleteproduct")
	public String deleteProduct(@RequestParam("pid") String pid,@RequestParam("sid") String sid, Model theModel) {
		productServices.deleteProduct(pid);
		theModel.addAttribute("sid",sid);
		theModel.addAttribute("msg","deleted successfully");
		return "renter-profile";
	}
	
	@RequestMapping("/updateproduct")
	public String updateProduct(HttpServletRequest request, Model theModel) {
		String sid=request.getParameter("sid");
		String pid=request.getParameter("productid");
		String productname=request.getParameter("productname");
		int productprice=Integer.parseInt(request.getParameter("productprice"));
		int productquantity=Integer.parseInt(request.getParameter("productquantity"));
		String category=request.getParameter("category");
		String city=request.getParameter("city");
		String status=productServices.updateProduct(pid,productname,productprice,productquantity,category,city);
		theModel.addAttribute("sid",sid);
		theModel.addAttribute("pid",pid);
		if(status!=null) {
			theModel.addAttribute("msg",status);
		}
		
		return "renter-profile";
	}
	
	@RequestMapping("/deleterenter/{sid}")
	public void deleteRenter(@PathVariable String sid) {
		productServices.deleteRenter(sid);
	}
	
	@RequestMapping("/updateform")
	public String updateForm(@RequestParam("pid") String pid , @RequestParam("sid") String sid, Model theModel) {
		List<Product> prod=productServices.fetchByProductId(pid);
		theModel.addAttribute("updatelist",prod);
		theModel.addAttribute("sid",sid);
		for(Product p:prod) {
			System.out.println(p.getProductname());
		}
		return "renter-profile";
	}
	
	@RequestMapping("/customersprofile")
	public String customerProfile(@RequestParam("cid") String cid, Model theModel) {
		List<Customer> customerdata=productServices.fetchByCustomerId(cid);
		for(Customer c:customerdata) {
			System.out.println(c.getCustomername());
		}
		theModel.addAttribute("cid",cid);
		theModel.addAttribute("customerdata",customerdata);
		return "customer-profile";
	}
	
}
