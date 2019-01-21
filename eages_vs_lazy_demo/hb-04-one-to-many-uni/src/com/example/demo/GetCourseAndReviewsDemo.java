package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {

//		create session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		System.out.println("Session factory is created");

		Session session = sessionFactory.getCurrentSession();
		System.out.println("Session is created");

		try {
			System.out.println("transaction started");

			session.beginTransaction();

			// create a course
			Course course = new Course("C");

			// add some reviews
			Review review1 = new Review("Awesome course");
			Review review2 = new Review("great course");
			Review review3 = new Review("great course, loved it");
			Review review4 = new Review("Well done");

			List<Review> reviewList = new ArrayList<>();
			reviewList.add(review1);
			reviewList.add(review2);
			reviewList.add(review3);
			reviewList.add(review4);
			
			course.setReviews(reviewList);

			// save the course.. and leverage the cascade All
			session.save(course);

			// commit the transaction
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
