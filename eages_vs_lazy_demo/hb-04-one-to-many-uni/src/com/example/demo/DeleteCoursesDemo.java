package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {

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
			
			Course course = session.get(Course.class, 1);
			
			session.delete(course);
			
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
