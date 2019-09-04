package com.mycompany.springdemo.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context=
					new ClassPathXmlApplicationContext("applicationContext.xml");
			Coach cc=context.getBean("cricCoach",CricketCoach.class);
			Coach cc2=context.getBean("cricCoach",CricketCoach.class);
			System.out.println(cc.getDailyWorkout());
			System.out.println(cc==cc2);
			
			Employee myCoach=context.getBean("theEmployee",Employee.class);
			System.out.println(myCoach.toString());
			
			BaseballCoach bc=context.getBean("baseCoach",BaseballCoach.class);
			System.out.println(bc.callFortune());
			
			CricketCoach iplteam=context.getBean("ipl",CricketCoach.class);
			System.out.println(iplteam.getDetails());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
