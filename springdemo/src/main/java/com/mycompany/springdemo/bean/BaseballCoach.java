package com.mycompany.springdemo.bean;

public class BaseballCoach implements Coach{

	private FortuneServiceImpl fortune;
	
	
	public BaseballCoach(FortuneServiceImpl fortune) {
		super();
		this.fortune = fortune;
	}

	public String callFortune() {
		return this.fortune.getFortune();
	}

	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Donald Trump is the new Baseball Coach";
	}

}
