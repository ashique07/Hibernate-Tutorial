package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.com.hibernate.demo.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try
		{
			//Use session to query objects
			
			//Start transaction
			session.beginTransaction();
			
			//Query: Get all Students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			System.out.println("Query: Get all Students");
			displayStudents(theStudents);
			
			//Query: Get all Students where lastName = 'Trump'
			theStudents = session.createQuery("from Student s where s.lastName='Trump'").getResultList();
			
			System.out.println("Query: Get all Students where lastName = 'Trump'");
			displayStudents(theStudents);
			
			//Query: Get all Students where lastName = 'Nabila' and firstName='Ahmed'
			theStudents = session.createQuery("from Student s where s.lastName='Ahmed' AND s.firstName='Nabila'").getResultList();
			
			System.out.println("Query: Get all Students where lastName = 'Nabila' and firstName='Ahmed'");
			displayStudents(theStudents);
			
			//Query: Get all Students where email like '%yahoo.com'
			theStudents = session.createQuery("from Student s where s.email like '%yahoo.com'").getResultList();
			
			System.out.println("Query: Get all Students where email like '%yahoo.com'");
			displayStudents(theStudents);
			
			//Commit transaction
			session.getTransaction().commit();
			
			
		}
		finally
		{
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tmpStudent : theStudents)
		{
			System.out.println(tmpStudent);
		}
	}

}