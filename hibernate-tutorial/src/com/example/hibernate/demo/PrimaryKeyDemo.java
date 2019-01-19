package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			// create multiple students
			System.out.println("Creating multiple objects");
			Student student1 = new Student("Akash1", "Daga1", "akash.daga+1@thinkvidya.com");
			Student student2 = new Student("Akash2", "Daga2", "akash.daga+2@thinkvidya.com");
			Student student3 = new Student("Akash3", "Daga3", "akash.daga+3@thinkvidya.com");

			// begin the session transaction
			System.out.println("Beginning the transaction");
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the studnets");
			session.save(student1);
			session.save(student2);
			session.save(student3);

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Saved Students");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}

	}

}
