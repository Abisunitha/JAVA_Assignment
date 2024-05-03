package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.StudentNotFoundException;
import com.model.Student;

public interface StudentDao  {

	List<Student> findAll()throws SQLException;

	void updateStuInfo(String firstName, String lastName, String dateOfBirth, String email, String phoneNumber,int studentId)throws SQLException;

	boolean checkStudentId(int studentId)throws StudentNotFoundException,SQLException;

	
	
	
}
