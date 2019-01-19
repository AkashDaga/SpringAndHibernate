package com.example.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	public static void main(String args[]) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// start transaction
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			System.out.println("Student Detail Befor Updation: "+student.toString());
			
			System.out.println(" Updating Student ");
			student.setFirstName("Bikash");
			
			/**
			 * this commit will automatically update the DB for us, we dont need to call update specifically 
			 * on session object
			 */
			// commit the transaction
			session.getTransaction().commit();
			
			// New Code
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update All the students mail id");
			
			session.createQuery("update Student set email='akash.daga@urbanpro.com'").executeUpdate();
			
			List<Student> studentList = session.createQuery("from Student").getResultList();
			
			System.out.println(studentList);
			
			session.getTransaction().commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
	}
}
