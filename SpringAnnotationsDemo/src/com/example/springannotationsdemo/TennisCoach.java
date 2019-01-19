package com.example.springannotationsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 
 * @author akash
 * 
 * if we doesn't define the bean Id then by default the bean Id will be class name with small letter of starting
 * alphabet. TennisCoach ----> tennisCoach
 *
 */
@Component("sillyTennisCoach")
public class TennisCoach implements Coach{
	private FortuneService fortuneService;
	
	/**
	 * 
	 * @param fortuneService
	 * 
	 * @Autowired annotation on such a constructor is no longer necessary 
	 * if the target bean only defines one constructor to begin with. 
	 * However, if several constructors are available, at least one must 
	 * be annotated to teach the container which one to use.
	 */
	@Autowired
	public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		// TODO Auto-generated constructor stub
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Do the workout like a champ";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
