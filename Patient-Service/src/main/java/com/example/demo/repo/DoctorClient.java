package com.example.demo.repo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Doctor;

@FeignClient("doctor")
public interface DoctorClient {

	@RequestMapping("/")
	public List<Doctor> findBySpeciality(@RequestParam("speciality") String speciality);
}
