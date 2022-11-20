package org.student;

import org.department.Department;

public class Student extends Department {
	
	public void studentName() {
		System.out.println("Enter the student name");
		
	}
	
	public void studentDept() {
		System.out.println("Enter the student department");
	}
	
    public void studentID() {
    	System.out.println("Enter the student id");
    }
	
	public static void main(String[] args) {
		Student details = new Student();
		details.studentName();
		details.studentID();
		details.studentDept();
		details.collegeName();
		details.collegeCode();
		details.collegeRank();
		details.deptName();

	}

}
