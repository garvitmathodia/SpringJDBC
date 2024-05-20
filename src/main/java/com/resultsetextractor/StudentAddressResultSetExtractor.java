package com.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentAddressResultSetExtractor implements ResultSetExtractor<Map<String , List<String>>> {

	@Override
	public Map<String, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Map<String, List<String>> studenttable = new HashMap<>();
		
		while(rs.next()) {
		
		String studentName = rs.getString("Student_Name");
		String studentAddress = rs.getString("Student_Address");
		
		List<String> studentNameList = studenttable.get(studentAddress);
		
		if(studentNameList==null) {
			ArrayList<String> newStudentList = new ArrayList<>();
			newStudentList.add(studentName);
			studenttable.put(studentAddress, newStudentList);
		}else {
			studentNameList.add(studentName);
		}
		
		}
		
		return studenttable;
	}

}



























