package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {

	public static void main(String[] args) {
		
		// Load the Spring Configuration File
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/*
		 * Now this is interesting cause as Spring is creating object via the configuration files using
		 * IoC containers, it is now configurable, as we are using the sub class of Coach class in the XML
		 * configuration if we give the class name as "com.springDemo.TrackCoach" then the class TrackCoach
		 * will be instantiated and if you change the class name in the configuration file of key myCoach to 
		 * "com.springDemo.BaseBallCoach" then it will instantiate BaseBallCoach class , we can create objects
		 * via bean factory also, but bean factory uses lazy loading and application context using aggressive 
		 * loading, and default scope of objects or beans is singleton, Application Context creates the object
		 * the time of loading application, and Bean Factory will create the object at the time of calling getBean
		 * method, Bean Factory doesn't support annotations, internationalization, Web based application. 
		 * Beans Factory is used only in stand alone application, to enable lazy loading in application context we need 
		 * to add lazyInit argument in bean tag 
		 */
		
		// Retrieve bean from Spring Container
		Coach theCoach = applicationContext.getBean("myCoach",Coach.class);
		
		//call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		
		// close the context
		applicationContext.close();
		

	}

}
