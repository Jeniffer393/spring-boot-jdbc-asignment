package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate template;

	int getCountOfUsers() {
		return template.queryForObject("select count(*) from Std1", Integer.class);
	}

	String getUserName(int id) {
		return template.queryForObject("select name from Std1 where id=?", new Object[] { id }, String.class);
	}

	int addStudent(Student student) {
		
		return template.update("insert Std1 user values(?,?,?)", new Object[] { student.getId(),student.getName(), student.getAddress() });

	}

	Student updateStudent(Student user, int id) {

		Integer verify = (template.update("update Std1 set name=? ,address=? where id=?", new Object[] { user.getName(), user.getId(), id }));
		if (verify instanceof Integer) {
			return template.queryForObject("select * from Std1 where id=?", new Object[] { user.getId() },
					new org.springframework.jdbc.core.RowMapper<Student>() {

						@Override
						public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
							// TODO Auto-generated method stub
							Student student = new Student();
							student.setName(rs.getString(1));
							student.setAddress(rs.getString(2));
							return student;
						}

					});
		} else {
			return null;
		}
	}

	int deleteStudent(int id) {
		
		return template.update("delete from Std1 where id=?", new Object[] { id });
	}

	java.util.List<Student> getAllStudents() {
		return template.query("Select * from Std1", new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rownumber) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setAddress(rs.getString(3));
				
				return student;
			}

		});
	}

}
