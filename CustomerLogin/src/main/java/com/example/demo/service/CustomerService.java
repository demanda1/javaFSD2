package com.example.demo.service;

import java.security.SecureRandom;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.MyCart;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MyCartRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class CustomerService {

	@Autowired ProductRepository productrepo;
	@Autowired CustomerRepository customerrepo;
	@Autowired OrderRepository orderrepo;
	@Autowired MyCartRepository mycartrepo;
	
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Customer createCustomer(Customer c) {
	
			String email= c.getCustomeremail();
			User customerAlreadyExists = customerrepo.findByCustomeremail(email);
			if(customerAlreadyExists==null) {
				c.setCustomerid(generateRandomString());
				
		//User user = mapper.map(userDetails, User.class);
		//becryptpassword
		String bpass=bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(bpass);
		UserDto userDto = mapper.map(user, UserDto.class);
		userRepo.save(user);
		return userDto;
			}
	   }
		System.out.println("user already exist.!");
		return null;
	}
	
	
	
	
	
	@Transactional
	public String saveCart(String cid, String pid, int quantity) {
		List<MyCart> cartlist=mycartrepo.findByCustomeridAndProductid(cid, pid);
		for(MyCart mc:cartlist) {
			System.out.println(mc.getQuantity());
			mc.setQuantity(quantity);
			return "succesfully updated!!";
		}
		return null;
		
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
	
	
	public static String generateRandomString() {
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";
        int length=6;
        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();
        if (length < 1) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }

	
}
