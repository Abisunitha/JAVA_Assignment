package com.dto;

public class GetEnrolledCourse {

	private String course_name;
	private int course_id;
	private String course_code;
	private String instructor_name;
	private int enrollment_id;
	private String enrollment_date;

	public GetEnrolledCourse(String course_name, int course_id, String course_code, String instructor_name,
			int enrollment_id, String enrollment_date) {
		super();
		this.course_name = course_name;
		this.course_id = course_id;
		this.course_code = course_code;
		this.instructor_name = instructor_name;
		this.enrollment_id = enrollment_id;
		this.enrollment_date = enrollment_date;
	
	}
	public GetEnrolledCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public String getInstructor_name() {
		return instructor_name;
	}
	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}
	public int getEnrollment_id() {
		return enrollment_id;
	}
	public void setEnrollment_id(int enrollment_id) {
		this.enrollment_id = enrollment_id;
	}
	public String getEnrollment_date() {
		return enrollment_date;
	}
	public void setEnrollment_date(String enrollment_date) {
		this.enrollment_date = enrollment_date;
	}
	
	@Override
	public String toString() {
		return "GetEnrolledCourse [course_name=" + course_name + ", course_id=" + course_id + ", course_code="
				+ course_code + ", instructor_name=" + instructor_name + ", enrollment_id=" + enrollment_id
				+ ", enrollment_date=" + enrollment_date + "]";
	}
	
	
}
