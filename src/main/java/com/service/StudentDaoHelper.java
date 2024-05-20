package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.StudentDAOImpl;
import com.school.api.Student;

@Service
public class StudentDaoHelper {

	private StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
	
	public void setUpStudentTable() {
		Student s1 = new Student();
		s1.setRollno(1);
		s1.setName("Aman Jain");
		s1.setAddress("Hindaun");
		
		Student s2 = new Student();
		s2.setRollno(2);
		s2.setName("Aman ojha");
		s2.setAddress("Bihar");
		
		Student s3 = new Student();
		s3.setRollno(3);
		s3.setName("Kalu");
		s3.setAddress("Biawar");
		
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		studentDAOImpl.insert(students);
	}
	public void printStudents(List<Student> students) {
		for(Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}
}
