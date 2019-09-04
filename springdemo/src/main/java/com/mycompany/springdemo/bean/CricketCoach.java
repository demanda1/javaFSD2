package com.mycompany.springdemo.bean;

public class CricketCoach implements Coach {

	private String email;
	private String teamName;
	
	
	
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


	public String getDetails() {
		return getEmail()+" "+getTeamName();
	}

	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Ravi Shastri is the new cricket coach";
	}

}
