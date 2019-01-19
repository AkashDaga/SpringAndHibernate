package com.example.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	public static void main(String args[]) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			// begin the transaction
			session.beginTransaction();

			System.out.println("Finding out all the students");
			// get all the students
			List<Student> studentsList = session.createQuery("from Student").getResultList();

			// display the result
			displayTheResult(studentsList);

			System.out.println("\nFinding out all the students whose last name is Daga");

			// get all the students whose last name is DAGA
			List<Student> studentListFilteredViaLastName = session.createQuery("from Student where lastName='Daga'")
					.getResultList();

			// display the result
			displayTheResult(studentListFilteredViaLastName);

			// get all the students whose last name is DAGA and first name is Akash
			System.out.println("\nFinding out all the students whose first name is Akash and last name is Daga");
			List<Student> studentListFitleredViaFirstNameLastName = session
					.createQuery("from Student where firstName='Akash' OR lastName='Daga'").getResultList();
			// display the result
			displayTheResult(studentListFitleredViaFirstNameLastName);

			// get all the students whose email ends with thinkvidya.com
			System.out.println("\nFinding out all the students whose email ends with thinkvidya.com");
			List<Student> studentListFitleredWithEmil = session
					.createQuery("from Student where email LIKE '%thinkvidya.com'").getResultList();
			// display the result
			displayTheResult(studentListFitleredWithEmil);

			// commit the changes
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}

	public static void displayTheResult(List<Student> list) {
		for (Student student : list) {
			System.out.println(student.toString());
		}
	}
}
