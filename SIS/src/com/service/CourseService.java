package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CourseDao;
import com.daoImpl.CourseDaoImpl;
import com.dto.AssignedTeacher;
import com.dto.GetEnrolledCourse;
import com.exception.CourseNotFoundException;
import com.model.Course;

public class CourseService {
     CourseDao dao=new CourseDaoImpl();
	public void findCourseid(int course_id) throws SQLException, CourseNotFoundException {
		// TODO Auto-generated method stub
		boolean iscustomeridvalid=dao.findOne(course_id);
		if(!iscustomeridvalid) {
			throw new CourseNotFoundException("course id invalid!!!");
		}
		dao.findOne(course_id);
	}
	public List<Course> findAll() throws SQLException, CourseNotFoundException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	public Course courseinfo(int courseId) throws SQLException {
		// TODO Auto-generated method stub
		return dao.courseinfo(courseId);
	}
	public List<AssignedTeacher> findteacher(int courseId) throws SQLException {
		// TODO Auto-generated method stub
		return dao.findteacher(courseId);
	}
	

}
