package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

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
			
			Instructor instructor = new Instructor("Pramod","Daga","pramod.daga@urbanpro.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("GeekyAnts","Playing Games");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.save(instructor);
			
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
