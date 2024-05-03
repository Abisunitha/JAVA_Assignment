package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.GetEnrolledCourse;
import com.exception.StudentNotFoundException;
import com.model.Enrollment;

public interface EnrollmentDao {

	int save(Enrollment enrollment)throws SQLException;

	List<GetEnrolledCourse> findcourse(int studentId)throws SQLException,StudentNotFoundException;

}
