package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserRequestModel;
import com.example.demo.UserServiceClient;

@RestController
public class UserController {

	 @Autowired
	 UserServiceClient userServiceClient;

	 @PostMapping("/fetchData")
	 public ResponseEntity <? > fetchData(@RequestBody UserRequestModel requestUser, Model theModel) {
		 System.out.println("printing.the data here");
		 System.out.println(ResponseEntity.ok(userServiceClient.findByMail(requestUser).getBody().getFirstname()));
		 System.out.println("inside fetch");
		theModel.addAttribute("data", ResponseEntity.ok(userServiceClient.findByMail(requestUser).getBody()));
	  return ResponseEntity.ok(userServiceClient.findByMail(requestUser));
	 }

}
