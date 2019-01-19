package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
	public static void main(String args[]) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
//			Instructor instructor = new Instructor("Akash","Daga","akash.daga@thinkvidya.com");
//			
//			InstructorDetail instructorDetail = new InstructorDetail("Programming Geek","Playing Games");
//			
//			instructor.setInstructorDetail(instructorDetail);
			
			Instructor instructor = new Instructor("Bikash", "Daga", "bikash.daga@thinkvidya.com");

			InstructorDetail instructorDetail = new InstructorDetail("Management Geek", "Playing Games");

			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			session.save(instructor);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

}
