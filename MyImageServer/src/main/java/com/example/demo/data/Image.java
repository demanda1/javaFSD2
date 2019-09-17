package com.example.demo.data;

public class Image {

	private long id;
	private String url;
	private String description;
	
	public Image(long id, String url, String description) {
		super();
		this.id = id;
		this.url = url;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
