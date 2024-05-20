package com.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.school.api.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student newstudent = new Student();
		newstudent.setRollno(rs.getInt("Roll_No"));
		newstudent.setName(rs.getString("Student_Name"));
		newstudent.setAddress(rs.getString("Student_Address"));
		System.out.println("maprow method called");
		return newstudent;
	}

	
}
