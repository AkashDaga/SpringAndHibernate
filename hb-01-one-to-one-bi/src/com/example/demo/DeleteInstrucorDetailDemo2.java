package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstrucorDetailDemo2 {
	public static void main(String args[]) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();

			int id = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

			// for cascade type NOT All we need to break the bi directional link between instructor and instruvtor_detail
			instructorDetail.getInstructor().setInstructorDetail(null);	
			session.delete(instructorDetail);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
