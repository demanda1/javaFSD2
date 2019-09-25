package com.example.demo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductRepository;

@Component
public class CpotBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired CustomerRepository customerrepo;
	@Autowired ProductRepository productrepo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
//		init();
	}
	
//	public void init() {
//		Customer c1=new Customer("c1","deepak mandal");
//		Customer c2=new Customer("c2","subham agrawal");
//		Customer c3=new Customer("c3","anuj singh");
//		
//		Product p1=new Product("p1","Trimmer",1500,3);
//		Product p2=new Product("p2","Powerbank",2000,4);
//		Product p3=new Product("p4","Oven",3000,2);
//		
//		customerrepo.save(c1);
//		customerrepo.save(c2);
//		customerrepo.save(c3);
//		
//		productrepo.save(p1);
//		productrepo.save(p2);
//		productrepo.save(p3);
//		
//	}

}
