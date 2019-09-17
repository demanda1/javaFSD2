package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Image;

@RestController
@RequestMapping("/")
public class ImageController {

	@RequestMapping("/images")
	public List<Image> getImages(){
		List<Image> imageList= Arrays.asList(new Image(1,"image1.com","myimage1"), new Image(2,"image.com","myimage2"));
		return imageList;
	}
}