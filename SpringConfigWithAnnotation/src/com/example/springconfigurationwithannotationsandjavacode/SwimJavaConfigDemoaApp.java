package com.example.springconfigurationwithannotationsandjavacode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoaApp {
	public static void main(String args[]) {
		// read spring configuration file
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringBeanConfig.class);

		Coach theCoach = applicationContext.getBean("swimCoach", Coach.class);

		System.out.println(theCoach.getDailyWorkOut());
		System.out.println(theCoach.getDailyFortune());
		// close the connection
		applicationContext.close();
	}
}
