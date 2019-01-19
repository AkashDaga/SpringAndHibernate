package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleMain {
	public static void main(String args[]) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"bean_lifecycle_application_context.xml");
		
		Coach theCoach = applicationContext.getBean("myCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		applicationContext.close();
	}
}
