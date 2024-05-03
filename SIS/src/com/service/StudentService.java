package com.service;

import java.sql.SQLException;

import java.util.List;


import com.dao.*;
import com.daoImpl.*;
import com.exception.StudentNotFoundException;
import com.model.Student;

public class StudentService {
    StudentDao dao=new StudentDaoImpl();
	public List<Student> findAll()throws SQLException {
		// TODO Auto-generated method stub
		
		return dao.findAll();
	}
	public void updateStuInfo(String firstName, String lastName, String dateOfBirth, String email, String phoneNumber,int studentId) throws SQLException,StudentNotFoundException {
		// TODO Auto-generated method stub
		dao.updateStuInfo(firstName,lastName,dateOfBirth,email,phoneNumber,studentId);
	}

	public void validateStudentId(int studentId) throws StudentNotFoundException, SQLException {
        if (!dao.checkStudentId(studentId)) {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found.");
        }
    }
	
}