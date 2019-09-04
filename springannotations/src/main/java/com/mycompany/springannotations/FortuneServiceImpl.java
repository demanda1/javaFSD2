package com.mycompany.springannotations;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements FortuneService {

	public String getFortune() {
		// TODO Auto-generated method stub
		return "Its your Lucky day";
	}

}
