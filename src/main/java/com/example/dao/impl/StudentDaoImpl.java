package com.example.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.IStudentDao;
import com.example.pojo.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void saveStudent(Student std) {
		
		System.out.println(std.getName());
		System.out.println(std.getCollegeName());
		Session session = sf.openSession();
		session.save(std);
		session.beginTransaction().commit();
		session.close();
		//save to database
	}

}
