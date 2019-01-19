package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	public static void main(String args[]) {
		// create session Factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		// get Session from session Factory
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// we need some id for retrieving the data, as of now we are going to place a static id
			
			// start the transaction
			session.beginTransaction();
			
			// retrieve the student based on the id
			Student student = session.get(Student.class, 2);
			
			System.out.println("retrieved student data from DB: "+student.toString());
			
			// commit the transaction
			session.getTransaction().commit();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}
}
