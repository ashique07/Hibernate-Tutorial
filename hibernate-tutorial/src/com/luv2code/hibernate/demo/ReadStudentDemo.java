package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try
		{
			//------Creating a new Student with current session--------
			
			//Create a Student object
			Student student = new Student("Donald","Trump","trump@holymail.com");
			
			//Start transaction
			session.beginTransaction();
			
			//Save student
			session.save(student);
			System.out.println("Created student: " + student);
			
			//Commit transaction
			session.getTransaction().commit();
			
			//------Reading the student with id = student.getId() with new session ----------
			
			//Get a NEW SESSION and start transaction for reading
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrieve student based on Primary Key
			System.out.println("Getting Student with id: " + student.getId());
			Student retrievedStudent = session.get(Student.class, student.getId());
			System.out.println("Retrieved student : " + retrievedStudent);
			
			//Commit transaction
			session.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}

	}

}