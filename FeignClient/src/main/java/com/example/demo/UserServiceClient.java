package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.UserRequestModel;
import com.example.demo.UserResponseModel;

@FeignClient("USER-WS")
public interface UserServiceClient {

	@PostMapping(value="/findByMail")
	public ResponseEntity<UserResponseModel> findByMail(@RequestBody UserRequestModel requestUser);
}
