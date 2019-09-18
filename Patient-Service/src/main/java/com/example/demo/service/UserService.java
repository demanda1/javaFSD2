package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Patient;
import com.example.demo.repo.PatientRepository;

@Service
public class UserService {
   @Autowired
	private PatientRepository patientRepository;

	
	public List<Patient> findByDisease(String disease) {
		List<Patient> patList=patientRepository.findByDisease(disease);
		return patList;
	}
	
}
