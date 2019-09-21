package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="renter")
public class Renter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String sellerid;
	private String sellername;
	@OneToMany(mappedBy = "renter", cascade = CascadeType.ALL)
	private List<Product> productlist;
	public Renter(String sellerid, String sellername) {
		super();
		this.sellerid = sellerid;
		this.sellername = sellername;
	}
	public Renter() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSellerid() {
		return sellerid;
	}
	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}
	public String getSellername() {
		return sellername;
	}
	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
	public List<Product> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	
}
