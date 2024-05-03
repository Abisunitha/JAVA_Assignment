package com.model;

public class Student {

	private int student_id;
	private String first_name;
	private String last_name;
	private String date_of_birth;
	private String email;
	private String phone_number;
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", date_of_birth=" + date_of_birth + ", email=" + email + ", phone_number=" + phone_number + "]";
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
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
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int student_id, String first_name, String last_name, String date_of_birth, String email,
			String phone_number) {
		super();
		this.student_id = student_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.phone_number = phone_number;
	}
}
