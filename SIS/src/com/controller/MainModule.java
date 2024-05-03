package com.controller;


import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dto.AssignedTeacher;
import com.dto.GetEnrolledCourse;

import com.exception.CourseNotFoundException;
import com.exception.StudentNotFoundException;
import com.model.Course;
import com.model.Enrollment;
import com.model.Student;
import com.service.CourseService;
import com.service.EnrollmentService;
import com.service.StudentService;


public class MainModule {

	public static void main(String[] args) throws StudentNotFoundException, CourseNotFoundException {
		StudentService studentService=new StudentService();
		CourseService courseService=new CourseService();
		EnrollmentService enrollmentService=new EnrollmentService();
		
		Scanner sc =new Scanner(System.in);
		
		while(true) {
			System.out.println("----------Student_Information_System-------------");
			System.out.println("Press 1. Display Student Details: ");
			System.out.println("Press 2. Update Student Details");
			System.out.println("press 3. Enrollin Course");
			System.out.println("press 4: Get Course Enrolled by Student");
			System.out.println("press 5: Display CourseInfo");
			System.out.println("press 6: Get Assigned Teacher for the course");
			System.out.println("press 0: Exit");
			int input=sc.nextInt();
			if(input==0) {
				System.out.println("Exiting Artist Module..");
				break;
			}
		    switch(input) {
		    case 1:
		    	try {
					List<Student> list=studentService.findAll();
					for(Student a :list) {
						System.out.println(a);
						
					}
					}catch(SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
		    case 2:
                try {
                    List<Student> students = studentService.findAll();  
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    System.out.println("Enter student ID to update:");
                    int studentId = sc.nextInt();
                    sc.nextLine();  
                    
                    studentService.validateStudentId(studentId);
                    System.out.println("Enter first name:");
                    String firstName = sc.nextLine();

                    System.out.println("Enter last name:");
                    String lastName = sc.nextLine();

                    System.out.println("Enter date of birth (yyyy-mm-dd):");
                    String dateOfBirth = sc.nextLine();

                   

                    System.out.println("Enter email:");
                    String email = sc.nextLine();

                    System.out.println("Enter phone number:");
                    String phoneNumber = sc.nextLine();
                    
                   

                    // Update student information
                    studentService.updateStuInfo(firstName, lastName, dateOfBirth, email, phoneNumber,studentId);

                    System.out.println("Student information updated successfully!");

                } catch (SQLException e) {
                    System.out.println("Error updating student information: " + e.getMessage());
                }catch(StudentNotFoundException e) {
                	System.out.println(e.getMessage());
                }
                break;
		    case 3:
		    	 try {
	                    List<Student> students = studentService.findAll();  
	                    for (Student student : students) {
	                        System.out.println(student);
	                    }
	                    System.out.println("Enter student ID:");
	                    int studentId = sc.nextInt();
	                    sc.nextLine();  
	                    studentService.validateStudentId(studentId);
	                    
	                    List<Course> course = courseService.findAll();  
	                    for (Course a : course) {
	                        System.out.println(a);
	                    }
	                   
	                    System.out.println("Enter course_id");
	                    int course_id=sc.nextInt();
	                    courseService.findCourseid(course_id);

	                    
	                    studentService.validateStudentId(studentId);
	                    Random random =new Random();
	    				int randomNumber = random.nextInt();
	    				int enrollment_id=randomNumber<0?randomNumber*-1:randomNumber;
	    				System.out.println("Enrollment id:" +enrollment_id);
	    				
	    				LocalDate currentDate = LocalDate.now(); // the current date
				        String enrollment_date = currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE); // "YYYY-MM-DD"
					    System.out.println("enrollment_date:" +enrollment_date);
					   
						Enrollment enrollment=new Enrollment(enrollment_id,enrollment_date,studentId,course_id);
						int status=enrollmentService.insert(enrollment);
					    if(status==1)
					    	System.out.println("enrollment record added to DB");
					    else
					    	System.out.println("Insert operation failed");
	                 }catch(SQLException e) {
	                	 System.out.println(e.getMessage());
	                 }catch(CourseNotFoundException e) {
	                	 System.out.println(e.getMessage());
	                 }catch(StudentNotFoundException e) {
	                	 System.out.println(e.getMessage());
	                 }
		    	 break;
		    case 4:
		    	try {
		    		List<Student> students = studentService.findAll();  
                    for (Student student : students) {
                        System.out.println(student);
                    }
					System.out.println("Enter student ID:");
					int studentId=sc.nextInt();
					 List<GetEnrolledCourse> list=enrollmentService.findcourse(studentId);
					
	                    for(GetEnrolledCourse a:list) {
	                    	System.out.println(a);
	                    }
			
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}catch(StudentNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
		    case 5:
		    	try {
		    		
		    		List<Course> course1 = courseService.findAll();  
                    for (Course a : course1) {
                        System.out.println("course id: "+a.getCourse_id());
                    }
                    System.out.println("Enter course_id");
                    int courseId=sc.nextInt();
                    courseService.findCourseid(courseId);
                    
                    Course course=courseService.courseinfo(courseId);
                    System.out.println(course);
		    	}catch(SQLException e) {
		    		System.out.println(e.getMessage());
		    	}catch(CourseNotFoundException e) {
		    		System.out.println(e.getMessage());
		    	}
		    	break;
		    case 6:
                  try {
		    		
		    		List<Course> course1 = courseService.findAll();  
                    for (Course a : course1) {
                        System.out.println(a);
                    }
                    System.out.println("Enter course_id");
                    int courseId=sc.nextInt();
                    courseService.findCourseid(courseId);
                    List<AssignedTeacher>course=courseService.findteacher(courseId);
                    for(AssignedTeacher a:course) {
                    	System.out.println(a);
                    }
                  }catch(SQLException e) {
                	  System.out.println(e.getMessage());
                  }catch(CourseNotFoundException e) {
                	  System.out.println(e.getMessage());
                  }
                  break;
		   
        }
    }
		
		sc.close();
	}
	}
