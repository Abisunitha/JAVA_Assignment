package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.EnrollmentDao;
import com.dao.StudentDao;
import com.daoImpl.EnrollmentDaoImpl;
import com.daoImpl.StudentDaoImpl;
import com.dto.GetEnrolledCourse;
import com.exception.StudentNotFoundException;
import com.model.Enrollment;

public class EnrollmentService {
      EnrollmentDao dao=new EnrollmentDaoImpl();
      StudentDao studentdao=new StudentDaoImpl();
	public int insert(Enrollment enrollment) throws SQLException {
		// TODO Auto-generated method stu
		
		return dao.save(enrollment);
	}
	public List<GetEnrolledCourse> findcourse(int studentId) throws StudentNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean isvalid=studentdao.checkStudentId(studentId);
		if(!isvalid) {
			throw new StudentNotFoundException("Invalid Student ID!!!");
		}
		return dao.findcourse(studentId);
	}

}
