package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

	public static void main(String[] args) {

//		create session factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		
		System.out.println("Session factory is created");
		
		Session  session = sessionFactory.getCurrentSession();
		System.out.println("Session is created");
		
		try {
			System.out.println("transaction started");
			
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			
			/**
			 * this will break the code as lazy loading requires session to make query in db, As in Lazy loading the required datas
			 * are loaded n demand not at the time of getting main data
			 */
//			session.close();
			
			System.out.println("courses ----> "+instructor.getCourses());
			
			session.getTransaction().commit();
			System.out.println("transction completed");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
