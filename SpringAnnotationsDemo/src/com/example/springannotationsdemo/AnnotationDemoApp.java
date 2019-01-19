package com.example.springannotationsdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
	public static void main(String args[]) {

		// read spring configuration file
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// constructor injection get the bean from IoC container
		Coach theCoach = applicationContext.getBean("sillyTennisCoach", Coach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());
		System.out.println(theCoach.getDailyFortune());

		// setter injection getting bean via default bean Id given by Spring
		theCoach = applicationContext.getBean("baseBallCoach", Coach.class);
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());
		System.out.println(theCoach.getDailyFortune());

		// setter injection getting bean via default bean Id given by Spring
		theCoach = applicationContext.getBean("badmintonCoach", Coach.class);
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());
		System.out.println(theCoach.getDailyFortune());

		// setter injection getting bean
		theCoach = applicationContext.getBean("DBCoach", Coach.class);
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());
		System.out.println(theCoach.getDailyFortune());

		// constructor injection getting bean
		theCoach = applicationContext.getBean("swimCoach", Coach.class);
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkOut());
		System.out.println(theCoach.getDailyFortune());

		// close the connection
		applicationContext.close();
	}
}
