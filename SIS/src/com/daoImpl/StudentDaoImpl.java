package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.StudentDao;
import com.exception.StudentNotFoundException;
import com.model.Student;
import com.utility.DBConnection;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select * from student";
		PreparedStatement pstmt= con.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		List<Student> list =new ArrayList<>();
		while(rst.next()==true) {
			int student_id=rst.getInt("student_id");
			String first_name=rst.getString("first_name");
			String last_name=rst.getString("last_name");
			String date_of_birth=rst.getString("date_of_birth");
			String email=rst.getString("email");
			String phone_number=rst.getString("phone_number");
			Student student = new Student(student_id,first_name,last_name,date_of_birth,email,phone_number);
			list.add(student);
		}
		DBConnection.dbClose();
		return list;
		
	}

	@Override
	public void updateStuInfo(String firstName, String lastName, String dateOfBirth, String email, String phoneNumber,int studentId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql = "UPDATE Student SET first_name = ?, last_name = ?, date_of_birth = ?, email = ?, phone_number = ? WHERE student_id = ?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setString(3, dateOfBirth);  
        statement.setString(4, email);
        statement.setString(5, phoneNumber);
        statement.setInt(6, studentId);

        statement.executeUpdate();  
       
    }

	@Override
	public boolean checkStudentId(int studentId) throws StudentNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnection.dbConnect();
		String sql="select student_id from student  where student_id=?";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, studentId);
		ResultSet rst=pstmt.executeQuery();
		boolean status=rst.next();
		DBConnection.dbClose();
		return status;
		
	}
		
	}

