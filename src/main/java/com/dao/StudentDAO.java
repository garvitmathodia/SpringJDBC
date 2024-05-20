package com.dao;

import java.util.List;
import java.util.Map;

import com.school.api.Student;

public interface StudentDAO {
	public void insert(Student s);
	
	public void insert(List<Student> students);
	
	public boolean deleteRecordByRollNo(int roolNo);
	
	public int deleteRecordByStudentNameOrStudentAddress(String studentName , String studentAddress);
	
	List<Student> findAllStudents();
	
	Student findStudentByRollNo(int rollNo);
	
	List<Student> findStudentByName(String name);
	
	Map<String , List<String>> groupStudentByAddress(); 
	
	int updateStudent(Student student);
	
	int updateStudent(List<Student> studentList);
}
