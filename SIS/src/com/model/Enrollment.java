package com.model;

public class Enrollment {
           private int enrollment_id;
           private String enrollment_date;
           private int student_id;
           private int course_id;

           public Enrollment() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Enrollment(int enrollment_id, String enrollment_date, int student_id, int course_id) {
			super();
			this.enrollment_id = enrollment_id;
			this.enrollment_date = enrollment_date;
			this.student_id = student_id;
			this.course_id = course_id;
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
		public int getStudent_id() {
			return student_id;
		}
		public void setStudent_id(int student_id) {
			this.student_id = student_id;
		}
		public int getCourse_id() {
			return course_id;
		}
		public void setCourse_id(int course_id) {
			this.course_id = course_id;
		}
		@Override
		public String toString() {
			return "Enrollment [enrollment_id=" + enrollment_id + ", enrollment_date=" + enrollment_date
					+ ", student_id=" + student_id + ", course_id=" + course_id + "]";
		}
		
}
