package com.example.springconfigurationwithannotationsandjavacode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach{
	
	/**
	 *  we can inject dependency using field injection also, here we don't need any setter method or other 
	 *  method to inject the dependency , if we do the Filed injection via @Autowied annotation, then in 
	 *  background Spring will inject the field via JAVA Reflection  
	 */

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public BadmintonCoach() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Smash the ball";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
