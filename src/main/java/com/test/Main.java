package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.school.api.Student;
import com.service.StudentDaoHelper;

public class Main {
	public static void main(String[] args) {
		Student s = new Student();
//		s.setRollno(12);
//		s.setName("Garvit");
//		s.setAddress("Jaipur");

		StudentDAO studentDAO = new StudentDAOImpl();
//		studentDAO.insert(s);
//		studentDAO.deleteRecordByRollNo(14);
//		List<Student> StudentList = studentDAO.findAllStudents();
//		Student student = studentDAO.findStudentByRollNo(3);
//		System.out.println(student);
//		List<Student> findStudentByName = studentDAO.findStudentByName("Garvit");
//		Map<String, List<String>> groupStudentByAddress = studentDAO.groupStudentByAddress();
//		System.out.println(groupStudentByAddress);
		StudentDaoHelper studentDaoHelper = new StudentDaoHelper();
//		studentDaoHelper.printStudents(findStudentByName);
//		studentDaoHelper.printStudents(StudentList);
//		studentDaoHelper.setUpStudentTable();

//		Student aman = new Student();
//		aman.setAddress("Gujrat");
//		aman.setRollno(2);
//		studentDAO.updateStudent(aman);
//		System.out.println("Aman's adadress has been updated");
		
		
		Student aman = new Student();
		aman.setAddress("Delhi");
		aman.setRollno(2);

		Student kalu = new Student();
		kalu.setAddress("Ajmer");
		kalu.setRollno(3);

		Student isht = new Student();
		isht.setAddress("Jaipur");
		isht.setRollno(15);

		List<Student> studentList = new ArrayList<>();

		studentList.add(aman);
		studentList.add(kalu);
		studentList.add(isht);

		studentDAO.updateStudent(studentList);

		System.out.println("batch update has been performed Successfully");
	}
}
