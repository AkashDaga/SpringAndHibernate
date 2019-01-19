package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	public static void main(String args[]) {

		// create session Factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// get the current session
		Session session = sessionFactory.getCurrentSession();

		try {
			// begin the transaction
			session.beginTransaction();

			// get the student you want to delete
			Student student = session.get(Student.class, 2);
			
			System.out.println("his student will be deleted ---> "+ student.toString());
			// delete the Student
			session.delete(student);
			
			// delete student where id is 3
			session.createQuery("delete from Student where id=3").executeUpdate();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}

	}

}
