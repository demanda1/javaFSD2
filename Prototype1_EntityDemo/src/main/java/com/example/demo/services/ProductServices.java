package com.example.demo.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.City;
import com.example.demo.entity.Product;
import com.example.demo.entity.Renter;
import com.example.demo.repo.CategoryRepository;
import com.example.demo.repo.CityRepository;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.RenterRepository;

@Service
public class ProductServices {

	@Autowired
	CityRepository cityrepo;
	@Autowired ProductRepository productrepo;
	@Autowired RenterRepository renterrepo;
	@Autowired CategoryRepository categoryrepo;
	public List<Product> showProduct(String category){
		List<Category> catobj=categoryrepo.findByCategory(category);
		for(Category c:catobj) {
			return c.getProductlist();
		}
		return null;
	}
	
	public List<Product> showProductByCity(String city){
		List<City> cityobj=cityrepo.findByCity(city);
		for(City c:cityobj) {
			return c.getProductlist();
		}
		return null;
	}
	public void createProduct(Product p,String sellerid,String category, String city) {
		
		List<Renter> renterList=renterrepo.findBySellerid(sellerid);
		List<Category> categoryList=categoryrepo.findByCategory(category);
		List<City> cityList=cityrepo.findByCity(city);
		for(Renter r:renterList) {
			p.setRenter(r);
			List<Product> prodlist=r.getProductlist();
			prodlist.add(p);
			r.setProductlist(prodlist);
			System.out.println(r.getSellername());
			
		   }
			for(Category c:categoryList) {
				p.setCategory(c);
				List<Product> prodlist=c.getProductlist();
				prodlist.add(p);
				c.setProductlist(prodlist);
				System.out.println(c.getCategory());
			}
			for(City c:cityList) {
				p.setCity(c);
				List<Product> prodlist=c.getProductlist();
				prodlist.add(p);
				c.setProductlist(prodlist);
				System.out.println(c.getCity());
				
			}
			productrepo.save(p);
	}
	
	@Transactional
	public void deleteProduct(String pid) {
		
		 productrepo.deleteByProductid(pid);
		
	}
	
	@Transactional
	public void updateProduct(String name, String pid) {
		List<Product> p=productrepo.findByProductid(pid);
		for(Product pro:p) {
			pro.setProductname(name);
		}
	}
	
	@Transactional
	public void deleteRenter(String sid) {
		renterrepo.deleteBySellerid(sid);
	}
}
