package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save the java object

			// create student object
			System.out.println("Creating new student object");

			Student student = new Student("Akash", "Daga", "akash.daga@thinkvidya.com");

			// start a transaction
			System.out.println("Begining the transaction");
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the studnet Object");
			session.save(student);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("DONE");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
