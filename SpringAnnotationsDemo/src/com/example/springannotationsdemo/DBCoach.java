package com.example.springannotationsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 
 * @author akash
 * 
 * For the case of RESTFortuneService

RESTFortuneService --> RESTFortuneService

No conversion since the first two characters are upper case.
 *
 */
@Component
public class DBCoach implements Coach{
	@Autowired
	@Qualifier("databaseFortuneService")
	FortuneService fortuneService;

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return " Practice SQL Query every now and then ";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	
}
