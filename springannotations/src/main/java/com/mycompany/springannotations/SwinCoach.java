package com.mycompany.springannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("sc2")
public class SwinCoach implements Coach {
	
	@Value("${myemail}")
	private String email;
	@Value("${myteam}")
	private String teamName;
	
	private FortuneService service;
	
	@Autowired
	public SwinCoach(FortuneService service) {
		super();
		this.service = service;
	}
	
	public SwinCoach() {
		super();
	}
	

	public SwinCoach(String email, String teamName) {
		super();
		this.email = email;
		this.teamName = teamName;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	

	public String getService() {
		return service.getFortune();
	}

	public void setService(FortuneService service) {
		this.service = service;
	}

	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
