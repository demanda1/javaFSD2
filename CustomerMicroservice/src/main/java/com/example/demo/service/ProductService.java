package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.MyCart;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MyCartRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired ProductRepository productrepo;
	@Autowired CustomerRepository customerrepo;
	@Autowired OrderRepository orderrepo;
	@Autowired MyCartRepository mycartrepo;
	
	public String addToCart(String pid,String cid) {
		List<Product> prodlist= productrepo.findByProductid(pid);
		List<Customer> cust=customerrepo.findByCustomerid(cid);
		for(Product p:prodlist) {
			for(Customer c:cust) {
				MyCart mc=new MyCart(c.getCustomerid(),p.getProductid(),1,1,null);
				mycartrepo.save(mc);
				return "saved in cart";
			}
		}
		return null;
	}
	
	@Transactional
	public String saveCart(String cid, String pid, int quantity) {
		List<MyCart> cartlist=mycartrepo.findByCustomeridAndProductid(cid, pid);
		List<Product> plist=productrepo.findByProductid(pid);
		for(Product p:plist) {
			System.out.println("inside product");
		if(p.getProductquantity()>=quantity) {
		for(MyCart mc:cartlist) {

			System.out.println(mc.getQuantity());
			mc.setQuantity(quantity);
			return "succesfully updated!!";
			}
		}
		}
		return "unsuccessfull";
		 
	}
	
	@Transactional
	public String orderProduct(String cid) {
		List<MyCart> cartlist=mycartrepo.findByCustomerid(cid);
		int orderstatus=0;
		for(MyCart mc:cartlist) {
			List<Product> plist=productrepo.findByProductid(mc.getProductid());
			for(Product p:plist) {
			if(mc.getCustomerid().equals(cid)&& p.getProductquantity()>=mc.getQuantity()) {
			Order o=new Order(mc.getCustomerid(),cid,mc.getProductid(),mc.getQuantity());
			orderrepo.save(o);
			
			mycartrepo.deleteByCustomerid(cid);
			List<Product> prodlist=productrepo.findByProductid(mc.getProductid());
			for(Product pl:prodlist) {
				int quantity=pl.getProductquantity()-mc.getQuantity();
				pl.setProductquantity(quantity);
				orderstatus=1;
			}
					
			}
			}
		}
		if(orderstatus==1) {
		return "Order successfully placed!";
		}
		else {
			return "null";
		}
	}
	
	public List<Product> viewcart(String cid) {
		List<MyCart> cartlist=mycartrepo.findByCustomerid(cid);
		List<String> pidlist=new ArrayList<>();
		for(MyCart mc:cartlist){
			
			pidlist.add(mc.getProductid().toString());
		}
		List<Product> plist=new ArrayList<>();
		for(String pid:pidlist) {
			List<Product> p=productrepo.findByProductid(pid);
			for(Product pro:p) {
				plist.add(pro);
			}
			p.clear();
		}
		return plist;
		
	}
	
	public List<MyCart> mycart(String cid) {
		List<MyCart> cartlist=mycartrepo.findByCustomerid(cid);
		return cartlist;
	}
	
	@Transactional
	public void deleteitem(String pid, String cid) {
		System.out.println("reached service of delete");
		List<MyCart> cartlist=mycartrepo.findByCustomerid( cid);
		for(MyCart mc:cartlist) {
			if(mc.getProductid().equals(pid)) {
			System.out.println(mc.getProductid());
			mycartrepo.delete(mc);
			}
		}
	}
	
	@Transactional
	public void setidproof(String idnum, String cid) {
		System.out.println("reached service of idproof");
		List<MyCart> cartlist=mycartrepo.findByCustomerid(cid);
		for(MyCart mc:cartlist) {
			mc.setIdproof(idnum);
			mycartrepo.save(mc);
			
		}
	}
	
	@Transactional
	public String walletpayment(String cid, String amount){
		List<Customer> clist=customerrepo.findByCustomerid(cid);
		
		for(Customer c:clist) {
			int netbal=c.getCustomerwallet()-Integer.parseInt(amount);
			c.setCustomerwallet(netbal);
			customerrepo.save(c);
			return "success";
		}
		return null;
	}
	
}
