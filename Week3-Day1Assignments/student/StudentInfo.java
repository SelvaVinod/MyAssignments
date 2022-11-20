package org.student;

public class StudentInfo {
	
	public void getStudentInfo(int id) {
		System.out.println("ID: " +id);
	}
	
	public void getStudentInfo (int id, String name){
		System.out.println("id and name: " +id+", " +name);
	
	}
	
	public void getStudentInfo (String mail, long phoneno) {
		System.out.println("mail and StuPhoNo: " +mail+", " +phoneno);
	
	}
	public static void main(String[] args) {
		StudentInfo test = new StudentInfo();
		test.getStudentInfo(18);
		test.getStudentInfo(18,"Kivisha");
		test.getStudentInfo("Kivi@gmail.com", 8939700442L);

	}

}
