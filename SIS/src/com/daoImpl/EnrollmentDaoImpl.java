package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.EnrollmentDao;
import com.dto.GetEnrolledCourse;
import com.exception.StudentNotFoundException;

import com.model.Enrollment;
import com.utility.DBConnection;

public class EnrollmentDaoImpl implements EnrollmentDao{

	@Override
	public int save(Enrollment enrollment) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="INSERT INTO enrollment (enrollment_id, student_id, course_id, enrollment_date) VALUES(?,?,?,?)";
		PreparedStatement pstmt= con.prepareStatement(sql);
		
		pstmt.setInt(1, enrollment.getEnrollment_id());
		pstmt.setInt(2, enrollment.getStudent_id());
		pstmt.setInt(3,enrollment.getCourse_id());
		pstmt.setString(4,enrollment.getEnrollment_date());
		
		int status=pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GetEnrolledCourse> findcourse(int studentId) throws SQLException, StudentNotFoundException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql=" SELECT e.enrollment_id,e.enrollment_date,c.course_name,c.course_code,c.course_id,c.instructor_name "
				+ " from enrollment e JOIN course c ON e.course_id=c.course_id "
				+ " where e.student_id =? ";
				
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, studentId);
		ResultSet rst=pstmt.executeQuery();
		List<GetEnrolledCourse> list =new ArrayList<>();
		while(rst.next()) {
			String course_name=rst.getString("course_name");
			int course_id=rst.getInt("course_id");
			String course_code=rst.getString("course_code");
			String instructor_name=rst.getString("instructor_name");
			int enrollment_id=rst.getInt("enrollment_id");
			String enrollment_date=rst.getString("enrollment_date");
			
			GetEnrolledCourse getEnrolledCourse = new GetEnrolledCourse(course_name,course_id,course_code,instructor_name,enrollment_id,enrollment_date);
			list.add(getEnrolledCourse);
		}
		DBConnection.dbClose();
		return list;
		
	
	}

}
