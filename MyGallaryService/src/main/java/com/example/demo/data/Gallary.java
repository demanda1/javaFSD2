package com.example.demo.data;

import java.awt.Image;
import java.util.List;

public class Gallary {
	private int id;
	private List<Object> list;

	public Gallary() {
		super();
	}
	public Gallary(int id, List<Object> list) {
		super();
		this.id = id;
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	
}
