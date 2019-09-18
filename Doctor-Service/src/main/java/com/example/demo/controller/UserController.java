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
import com.example.demo.repo.PateintClient;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private PateintClient patientClient;
	
	@RequestMapping("/")
	private List<Doctor> findBySpeciality(@RequestParam("speciality") String speciality){
		System.out.println(speciality);
		List<Doctor> mydoctors=userService.findBySpeciality(speciality);
		return mydoctors;
	}
	
	@RequestMapping("/findpatient")
	private ResponseEntity<List<Patient>> findPatient(@RequestParam("disease") String disease){
		return ResponseEntity.status(HttpStatus.CREATED).body(patientClient.findByDisease(disease));
	}
}
