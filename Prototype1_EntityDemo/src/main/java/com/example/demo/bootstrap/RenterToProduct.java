package com.example.demo.bootstrap;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Category;
import com.example.demo.entity.City;
import com.example.demo.entity.Product;
import com.example.demo.entity.Renter;
import com.example.demo.repo.CategoryRepository;
import com.example.demo.repo.CityRepository;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.RenterRepository;

@Component
public class RenterToProduct implements ApplicationListener<ContextRefreshedEvent> {
	
//	private ProductRepository productrepo;
//	private RenterRepository renterrepo;
//	private CategoryRepository categoryrepo;
//	private CityRepository cityrepo;
//	public RenterToProduct(ProductRepository productrepo, RenterRepository renterrepo, CategoryRepository categoryrepo, CityRepository cityrepo) {
//		super();
//		this.productrepo = productrepo;
//		this.renterrepo = renterrepo;
//		this.categoryrepo=categoryrepo;
//		this.cityrepo=cityrepo;
//	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		// TODO Auto-generated method stub
//		init();
	}
//	
//	private void init() {
//	        
//	}

}
