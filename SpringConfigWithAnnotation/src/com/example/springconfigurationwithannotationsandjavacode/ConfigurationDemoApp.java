package com.example.springconfigurationwithannotationsandjavacode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigurationDemoApp {
	public static void main(String args[]) {

		// read spring configuration file
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringConfig.class);
		
		Coach theCoach = applicationContext.getBean("tennisCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkOut());
		System.out.println(theCoach.getDailyFortune());
		// close the connection
		applicationContext.close();
	}
}
