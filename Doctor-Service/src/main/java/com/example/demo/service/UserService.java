package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.repo.DoctorRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {
   @Autowired
	private DoctorRepository doctorRepository;
  
   
	public List<Doctor> findBySpeciality(String speciality) {
		List<Doctor> docList=doctorRepository.findBySpeciality(speciality);
		return docList;
	}
	
}
