package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.repo.DoctorClient;
import com.example.demo.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private DoctorClient doctorClient;
	
	@RequestMapping("/")
	private List<Patient> findByDisease(@RequestParam("disease") String disease){
		System.out.println(disease);
		List<Patient> mypatient=userService.findByDisease(disease);
		return mypatient;
	}
	
	@RequestMapping("/finddoctor")
	private ResponseEntity<List<Doctor>> findDoctor(@RequestParam("speciality") String speciality){
		return ResponseEntity.status(HttpStatus.CREATED).body(doctorClient.findBySpeciality(speciality));
	}
	
	
}
