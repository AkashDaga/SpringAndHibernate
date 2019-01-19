package com.example.springconfigurationwithannotationsandjavacode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {
	private FortuneService fortuneService;

	public BaseBallCoach() {
	}
	/**
	 * 
	 * @param fortuneService
	 * 
	 * any method name can be used to dependency Injection, 
	 * only the method needs to be annotated by @Autowired 
	 * 
	 */
	
	@Autowired
	@Qualifier("restfulFortuneService")
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Hit a home run";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
