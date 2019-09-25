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
import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.entity.Renter;
import com.example.demo.repo.CategoryRepository;
import com.example.demo.repo.CityRepository;
import com.example.demo.repo.ProductRepository;
import com.example.demo.repo.RenterRepository;
import com.example.demo.repo.CustomerRepository;
import com.example.demo.repo.MyCartRepository;
import com.example.demo.repo.OrderRepository;

@Service
public class ProductServices {

	@Autowired
	CityRepository cityrepo;
	@Autowired ProductRepository productrepo;
	@Autowired RenterRepository renterrepo;
	@Autowired CategoryRepository categoryrepo;
	@Autowired CustomerRepository customerrepo;
	@Autowired OrderRepository orderrepo;
	@Autowired MyCartRepository mycartrepo;
	
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
	
	@Transactional
	public List<Product> showRenterProduct(String sid) {
		List<Renter> renterobj=renterrepo.findBySellerid(sid);
		for(Renter r:renterobj) {
			return r.getProductlist();
		}
		return null;
	}
	
	public String createProduct(Product p,String sellerid,String category, String city) {
		
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
			return "Your product was successfully listed";
	}
	
	@Transactional
	public void deleteProduct(String pid) {
		
		 productrepo.deleteByProductid(pid);
		
	}
	
	@Transactional
	public String updateProduct(String pid,String productname,int productprice,int productquantity,String category,String city) {
		List<Product> p=productrepo.findByProductid(pid);
		for(Product pro:p) {
			pro.setProductname(productname);
			pro.setProductprice(productprice);
			pro.setProductquantity(productquantity);
			List<Category> catobj=categoryrepo.findByCategory(category);
			for(Category c:catobj) {
				pro.setCategory(c);
			}
			List<City> cityobj=cityrepo.findByCity(city);
			for(City c:cityobj) {
				pro.setCity(c);
			}
			return "updated successfully!!";
		}
		return null;
	}
	
	@Transactional
	public void deleteRenter(String sid) {
		renterrepo.deleteBySellerid(sid);
	}
	
	public List<Product> fetchByProductId(String pid) {
		List<Product> myprod=productrepo.findByProductid(pid);
		return myprod;
	}
	
	public List<Customer> fetchByCustomerId(String cid){
		List<Customer> mycust=customerrepo.findByCustomerid(cid);
		return mycust;
	}
}

