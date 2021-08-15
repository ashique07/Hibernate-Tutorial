package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try
		{
			
			//-----Update Student's first name with ID = 1-----
			
			//Get a new session
			session = factory.getCurrentSession();
			
			//Start transaction
			session.beginTransaction();
			
			int studentId = 1;
			Student myStudent = session.get(Student.class, studentId);
			
			//Update first name to "Chunnu"
			myStudent.setFirstName("Chunnu");
			
			//Commit transaction
			session.getTransaction().commit();
			
			//-----Update all Student's email to 'amornab@gmail.com'-----
			
			//Get a new seesion
			session = factory.getCurrentSession();
			
			//Start transaction
			session.beginTransaction();
			
			//Update all Student's email to 'amornab@gmail.com'
			session.createQuery("update Student set email='amornab@gmail.com'").executeUpdate();
			
			//Commit transaction
			session.getTransaction().commit();
			
			
			
		}
		finally
		{
			factory.close();
		}

	}

}