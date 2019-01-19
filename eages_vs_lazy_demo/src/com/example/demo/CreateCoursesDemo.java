package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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
			
			Course course = new Course("J2EE");
			instructor.add(course);
		
			session.save(course);
			
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
