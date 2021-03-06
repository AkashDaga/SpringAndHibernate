package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

	public static void main(String[] args) {

//		create session factory

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		System.out.println("Session factory is created");

		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session is created");

		try {
			System.out.println("transaction started");

			session.beginTransaction();

			int id = 1;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + " JOIN FETCH i.courses " + "WHERE i.id =: theInstructorId",
					Instructor.class);
			query.setParameter("theInstructorId", id);
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println(instructor.toString());

			session.getTransaction().commit();
			System.out.println("transction completed");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
