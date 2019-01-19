package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
	public static void main(String args[]) {

		/*
		 * if scope of the bean defines in the configuration is prototype then every
		 * time we create an object of same id, spring container will return new object.
		 * if the scope is not defined by default it is singleton and doesn't matter how
		 * many times you are creating the object, it will return the same object
		 */

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"bean_application_context.xml");

		Coach theCoach = applicationContext.getBean("myCoach", Coach.class);

		Coach alphaCoach = applicationContext.getBean("myCoach", Coach.class);

		boolean isSame = theCoach == alphaCoach;

		System.out.println(" is pointing to the same object reference ? " + isSame);
		System.out.println(" theCoach reference ----> " + theCoach);
		System.out.println(" alphaCoach reference ----> " + alphaCoach);

		theCoach = applicationContext.getBean("myCoachPrototype", Coach.class);

		alphaCoach = applicationContext.getBean("myCoachPrototype", Coach.class);

		isSame = theCoach == alphaCoach;

		System.out.println(" is pointing to the same object reference ? " + isSame);
		System.out.println(" theCoach reference ----> " + theCoach);
		System.out.println(" alphaCoach reference ----> " + alphaCoach);

		applicationContext.close();
	}

}
