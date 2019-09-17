package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.ContractRepo;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.repository.PermanentRepo;
@Controller
public class DemoController {

	private EmployeeRepo employeerepo;
	private ContractRepo contractrepo;
	private PermanentRepo permanentrepo;
	
	
	
	public DemoController(EmployeeRepo employeerepo, ContractRepo contractrepo, PermanentRepo permanentrepo) {
		super();
		this.employeerepo = employeerepo;
		this.contractrepo = contractrepo;
		this.permanentrepo = permanentrepo;
	}



	@RequestMapping("/")
	public String showHome(Model theModel) {
		System.out.println("reached!1223");
		theModel.addAttribute("emp",employeerepo.findAll());
		return "main-menu";
	}
}
