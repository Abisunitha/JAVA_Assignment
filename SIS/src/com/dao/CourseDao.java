package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.AssignedTeacher;
import com.exception.CourseNotFoundException;
import com.model.Course;

public interface CourseDao {

	boolean findOne(int course_id)throws SQLException,CourseNotFoundException;

	List<Course> findAll()throws SQLException,CourseNotFoundException;

	Course courseinfo(int courseId)throws SQLException;

	List<AssignedTeacher> findteacher(int courseId)throws SQLException;

}
