package com.example.springannotationsdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
	public static void main(String args[]) {

		// read spring configuration file
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		Coach alphaCoach = applicationContext.getBean("sillyTennisCoach",Coach.class);
		
		Coach betaCoach = applicationContext.getBean("sillyTennisCoach",Coach.class);
		
		boolean isSame = alphaCoach == betaCoach;
		System.out.println("is alphaCoach and betaCoach is same ? "+isSame);
		
		System.out.println("Alpha coach memory location "+alphaCoach);
		System.out.println("Beta coach memory location "+betaCoach);
		
		
		Coach swimCoach = applicationContext.getBean("swimCoach",Coach.class);
		// close the connection
		applicationContext.close();
	}
}
