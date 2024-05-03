package com.dto;

public class AssignedTeacher {
   private String first_name;
   private String last_name;
   private String course_name;
   private int course_id;
public AssignedTeacher(String first_name, String last_name, String course_name, int course_id) {
	super();
	this.first_name = first_name;
	this.last_name = last_name;
	this.course_name = course_name;
	this.course_id = course_id;
}
public AssignedTeacher() {
	super();
	// TODO Auto-generated constructor stub
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
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
@Override
public String toString() {
	return "AssignedTeacher [first_name=" + first_name + ", last_name=" + last_name + ", course_name=" + course_name
			+ ", course_id=" + course_id + "]";
}


}
