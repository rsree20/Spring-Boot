package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.IStudentDao;
import com.example.pojo.Student;

@RestController
public class IplService {

	@Autowired
	private IStudentDao dao;
	
	@RequestMapping(value = "/testCon")
	public String testConnection() {
		System.out.println("Connection success");
		return "success";
	}

	@RequestMapping(value = "/updateStd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Student updateStudent(@RequestBody Student std) {
		
		System.out.println("update student triggered!!");
		std.setCollegeName("Aurora");
		dao.saveStudent(std);
		return std;
	}
}
