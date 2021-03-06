package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String productid;
	private String productname;
	private int productprice;
	private int productquantity;
	@ManyToOne
	@JoinColumn(name="renterid")
	private Renter renter;
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	@ManyToOne
	@JoinColumn(name="cityid")
	private City city;
	
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Renter getRenter() {
		return renter;
	}
	public void setRenter(Renter renter) {
		this.renter = renter;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", productprice=" + productprice
				+ ", productquantity=" + productquantity + "]";
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Product() {
		super();
	}
	public Product(String productid, String productname, int productprice, int productquantity) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productprice = productprice;
		this.productquantity = productquantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	public int getProductquantity() {
		return productquantity;
	}
	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}
    
}
