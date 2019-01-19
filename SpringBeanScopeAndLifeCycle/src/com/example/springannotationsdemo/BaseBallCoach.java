package com.example.springannotationsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {
	private FortuneService fortuneService;

	public BaseBallCoach() {
		System.out.println("BaseBallCoach has been instantiated");
	}

	@Autowired
	@Qualifier("restfulFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("setFortuneService() is fired");
		this.fortuneService = fortuneService;
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
		System.out.println("doSomeCrazyStuff() is fired");
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
