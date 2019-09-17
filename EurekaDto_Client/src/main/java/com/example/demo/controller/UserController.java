package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.httpModel.UserRequestModel;
import com.example.demo.httpModel.UserResponseModel;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/insertuser")
	public ResponseEntity<UserResponseModel> insertUser(@RequestBody UserRequestModel requestUser)
	{  System.out.println("inside insert user");
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userdto=mapper.map(requestUser, UserDto.class);
		userdto = userService.insertUser(userdto);
		UserResponseModel responseModel=mapper.map(userdto,UserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
	}
	
	@PostMapping("/findByMail")
	public ResponseEntity<UserResponseModel> findByMail(@RequestBody UserRequestModel requestUser)
	{
		System.out.println("inside find by email");
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userdto=mapper.map(requestUser,UserDto.class);
		userdto=userService.findByEmail(userdto);
		//System.out.println(userdto.getFirstname()+" "+userdto.getLastname());
		UserResponseModel responseModel=mapper.map(userdto,UserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
	}
}
