package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.CourseDao;
import com.dto.AssignedTeacher;
import com.exception.CourseNotFoundException;
import com.model.Course;

import com.utility.DBConnection;

public class CourseDaoImpl implements CourseDao {

	@Override
	public boolean findOne(int course_id) throws SQLException, CourseNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select course_id from course where course_id=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, course_id);
		ResultSet rst=pstmt.executeQuery();
		boolean status=rst.next();
		DBConnection.dbClose();
		return status;
		
	}

	@Override
	public List<Course> findAll() throws SQLException, CourseNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select * from course";
		PreparedStatement pstmt= con.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		List<Course> list =new ArrayList<>();
		while(rst.next()==true) {
			int course_id=rst.getInt("course_id");
			String course_name=rst.getString("course_name");
			String course_code=rst.getString("course_code");
			String instructor_name=rst.getString("instructor_name");
			int teacher_id=rst.getInt("teacher_id");
			
			Course course = new Course(course_id,course_name,course_code,instructor_name,teacher_id);
			list.add(course);
		}
		DBConnection.dbClose();
		return list;
		
	}

	@Override
	public Course courseinfo(int courseId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select * from course where course_id =? ";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, courseId);
		ResultSet rst=pstmt.executeQuery();
		Course course=null;
		if(rst.next()) {
			int course_id=rst.getInt("course_id");
			String course_name=rst.getString("course_name");
			String course_code=rst.getString("course_code");
			String instructor_name=rst.getString("instructor_name");
			int teacher_id=rst.getInt("teacher_id");
		    course = new Course(course_id,course_name,course_code,instructor_name,teacher_id);
		
		}
		DBConnection.dbClose();
		return course;
	}

	@Override
	public List<AssignedTeacher> findteacher(int courseId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select c.course_name,c.course_id,t.first_name,t.last_name from course c"
				+ " join teacher t on t.teacher_id=c.teacher_id where c.course_id=? ";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, courseId);
		ResultSet rst=pstmt.executeQuery();
		List<AssignedTeacher> list =new ArrayList<>();
		while(rst.next()==true) {
			int course_id=rst.getInt("course_id");
			String course_name=rst.getString("course_name");
			String first_name=rst.getString("first_name");
			String last_name=rst.getString("last_name");
			
			AssignedTeacher course = new AssignedTeacher(first_name,last_name,course_name,course_id);
			list.add(course);
		}
		DBConnection.dbClose();
		return list;
		
		
	}

}
