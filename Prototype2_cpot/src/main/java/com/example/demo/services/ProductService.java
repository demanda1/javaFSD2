package com.example.demo.services;

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
				MyCart mc=new MyCart(cid,pid);
				mycartrepo.save(mc);
				return "saved in cart";
			}
		}
		return null;
	}
	
	@Transactional
	public String orderProduct(String cid) {
		List<MyCart> cartlist=mycartrepo.findByCustomerid(cid);
		int orderstatus=0;;
		for(MyCart mc:cartlist) {
			List<Product> plist=productrepo.findByProductid(mc.getProductid());
			for(Product p:plist) {
			if(mc.getCustomerid().equals(cid)&& p.getProductquantity()>0) {
			Order o=new Order(mc.getCustomerid()+mc.getProductid(),cid,mc.getProductid());
			orderrepo.save(o);
			mycartrepo.deleteByCustomerid(cid);
			List<Product> prodlist=productrepo.findByProductid(mc.getProductid());
			for(Product pl:prodlist) {
				int quantity=pl.getProductquantity()-1;
				p.setProductquantity(quantity);
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
	
}
