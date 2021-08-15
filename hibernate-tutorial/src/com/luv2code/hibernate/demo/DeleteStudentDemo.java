package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try
		{
			
			//-----Delete Student with ID = 4-----
			
			//Get a new session
			session = factory.getCurrentSession();
			
			//Start transaction
			session.beginTransaction();
			
			int studentId = 4;
			Student myStudent = session.get(Student.class, studentId);
			
			//Delete Student
			session.delete(myStudent);
			
			//Commit transaction
			session.getTransaction().commit();
			
			//-----Delete Student with ID = 5-----
			
			
			//Get a new seesion
			session = factory.getCurrentSession();
			
			//Start transaction
			session.beginTransaction();
			
			//Delete Student
			session.createQuery("delete from Student where id = 5").executeUpdate();
			
			//Commit transaction
			session.getTransaction().commit();
			
			
			
		}
		finally
		{
			factory.close();
		}

	}

}