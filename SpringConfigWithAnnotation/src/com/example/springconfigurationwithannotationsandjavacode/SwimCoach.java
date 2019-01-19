package com.example.springconfigurationwithannotationsandjavacode;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class SwimCoach implements Coach {
	@Value("${name}")
	String name;
	@Value("${email}")
	String email;
	
	FortuneService fortuneService;
	public SwimCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return name+" "+"Swim 10 kms and then mail me at "+email;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
//	@PostConstruct
//	public void doMyStartUpStuff() {
//		System.out.println("doMyStartUpStuff is fired");
//	}
//	
//	@PreDestroy
//	public void doMyCleanUpStuff() {
//		System.out.println("doMyCleanUpStuff is fired");
//	}

}
