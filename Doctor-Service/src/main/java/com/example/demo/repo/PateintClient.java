package com.example.demo.repo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Patient;

@FeignClient("patient")
public interface PateintClient {

	@RequestMapping("/")
	public List<Patient> findByDisease(@RequestParam("disease") String disease);
}
