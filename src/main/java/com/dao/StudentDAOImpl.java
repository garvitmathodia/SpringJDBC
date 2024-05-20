package com.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.resultsetextractor.StudentAddressResultSetExtractor;
import com.resultsetextractor.StudentResultSetExtractor;
import com.rowmapper.StudentRowMapper;
import com.school.api.Student;

import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
	// you just need to configure all the classes info into web.xml file.....

	private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

	@Override
	public void insert(Student s) {
		String sql = "Insert into student values(? , ? , ?)";
		Object[] arg = { s.getRollno(), s.getName(), s.getAddress() };
		jdbcTemplate.update(sql, arg);
	}

	public DataSource getDataSource() {
		String url = "jdbc:mysql://127.0.0.1:3306/school";
		String username = "root";
		String password = "qwertyuiop";
		DataSource dataSource = new DriverManagerDataSource(url, username, password);
		return dataSource;
	}

	@Override
	public boolean deleteRecordByRollNo(int roolNo) {
		String sql = "DELETE FROM STUDENT WHERE Roll_No = ?";
		int noOfrows = jdbcTemplate.update(sql, roolNo);
		System.out.println("No. of rows deleted are :" + noOfrows);
		return noOfrows == 1;
	}

	@Override
	public int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress) {
		String sql = "Delete from student where studentName = ? Or studentAddress = ?";
		int noOfRowsDeleted = jdbcTemplate.update(sql, studentName, studentAddress);
		System.out.println("No. of rows deleted are :" + noOfRowsDeleted);
		return noOfRowsDeleted;
	}

	public void cleanUp() {
		String sql = "Truncate table student";
		jdbcTemplate.execute(sql);
		System.out.println("Table cleaned up");
	}

	@Override
	public void insert(List<Student> students) {

		String sql = "insert into student values(? , ? , ?)";
		ArrayList<Object[]> sqlArgs = new ArrayList<>();
		for (Student tempStudent : students) {
			Object[] studentData = { tempStudent.getRollno(), tempStudent.getName(), tempStudent.getAddress() };
			sqlArgs.add(studentData);
		}

		jdbcTemplate.batchUpdate(sql, sqlArgs);
		System.out.println("batch Update Complete");
	}

	@Override
	public List<Student> findAllStudents() {

		String sql = "Select * from student";

		List<Student> studentList = jdbcTemplate.query(sql, new StudentRowMapper());

		return studentList;
	}

	@Override
	public Student findStudentByRollNo(int rollNo) {
		String sql = "Select Roll_No as rollno , Student_Name as name , Student_Address as address from student where Roll_No = ? ";

		Student student = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), rollNo);
		return student;
	}

	@Override
	public List<Student> findStudentByName(String name) {
		String sql = "Select * from student where Student_Name = ?";

		List<Student> studentList = jdbcTemplate.query(sql, new StudentResultSetExtractor(), name);

		return studentList;
	}

	@Override
	public Map<String, List<String>> groupStudentByAddress() {
		String sql = "Select * from student";
		Map<String, List<String>> StudentMapping = jdbcTemplate.query(sql, new StudentAddressResultSetExtractor());
		return StudentMapping;
	}

	@Override
	public int updateStudent(Student student) {

		String sql = "Update student set Student_Address = ? where Roll_No = ?";

		Object[] args = { student.getAddress(), student.getRollno() };

		return jdbcTemplate.update(sql, args);
	}

	@Override
	@Transactional
	public int updateStudent(List<Student> studentList) {

		String sql = "Update student set Student_Address = ? where Roll_No = ?";

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				// i need to set the values for preparedstatement

				ps.setString(1, studentList.get(index).getAddress());
				ps.setInt(2, studentList.get(index).getRollno());

			}

			@Override
			public int getBatchSize() {
				// in this method we need to define that how many times our query going to
				// execute..
				// how many times the setvalues method going to execute

				return studentList.size();
			}
		});

		return 0;
	}

}



































