package com.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.school.api.Student;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>>{

	@Override
	public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Student> studentList = new ArrayList<>();
		while(rs.next()) {
			Student newstudent = new Student();
			newstudent.setRollno(rs.getInt("Roll_No"));
			newstudent.setName(rs.getString("Student_Name"));
			newstudent.setAddress(rs.getString("Student_Address"));
			studentList.add(newstudent);
		}
		System.out.println("inside studentresultsetextractor");
		return studentList;
	}

	
	 
}
