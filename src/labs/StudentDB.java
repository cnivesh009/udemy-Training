/*
 *  @author		: Nivesh Chandola
 *  Created on	: 12/08/2019, 10:18:23 PM
 *  Program		: Student Database	
 *  Last Edited	: 17/08/2019
 */
package labs;

import com.mysql.cj.util.StringUtils;
import java.util.Scanner;

public class StudentDB {

	static Scanner val = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Enter the number of students to enrol: ");

		int num_of_stud = val.nextInt();
		val.nextLine();	//	consumes \n, hence, input from user is not skipped

		stdArray(num_of_stud);
//		showInfo(num_of_stud);

	}

	public static void stdArray(int num_of_stud) {
		String[] course = {"Math101", "CompSc105", "Physics201"};
		Student[] stud_obj = new Student[num_of_stud];
		for (int n = 0; n < num_of_stud; n++) {
			System.out.println("Enter student" + (n + 1) + "'s details");
			Stud_Name_SSN(num_of_stud);
			for (int i = 0; i < 3; i++) {
				stud_obj[n].Enrol(course);
			}
			stud_obj[n].payFee();
			System.out.println();
		}
	}

	public static void Stud_Name_SSN(int num_of_stud) {

		String Firstname, Lastname, SSN;
		String name;
		Student[] stud_obj = new Student[num_of_stud];
		System.out.print("Enter First name: ");
		Firstname = val.nextLine();

		System.out.print("Enter Last name: ");
		Lastname = val.nextLine();

		name = Firstname + " " + Lastname;

		System.out.print("Enter SSN: ");
		SSN = val.nextLine();
		for (int i = 0; i < num_of_stud; i++) {
			stud_obj[i] = new Student(name, SSN);
		}

	}

	public static void showInfo(int num_of_stud) {
		Student[] stud_obj = new Student[num_of_stud];
		System.out.println("\n-------------------------Student Information-------------------------");
		for (int m = 0; m < num_of_stud; m++) {
			System.out.println(stud_obj[m].toString());
			System.out.println("\n");
		}
	}

}

class Student {

	//	set private static id and encapsulation
	private static int id = 1000;
	private String user_id;
	private String name;
	private String SSN;
	private String email;
	private static String Courses = "";
	private static final int CourseCost = 600;
	private int tuitionBalance = 0;

	private int phone;
	private int city;
	private int state;

	public Student(String name, String SSN) {
		id++;

		//	constructor takes New student's name and SSN
		this.name = name;
		this.SSN = SSN;

		setUserId();
		//	generate email based on name
		setEmail();

	}

	private void setEmail() {
		//	\\s+ replaces all whitespaces with "" (no spaces)
		email = name.replaceAll("\\s+", "").toLowerCase() + "@student.edu.au";
	}

	private void setUserId() {
		//	user id = static id + rand 4 digit number (1k-9K)+ last 4 digit of SSN
		int max = 9000, min = 1000;
		int rNum = (int) (Math.random() * (max - min));
		user_id = id + "" + rNum + SSN.substring(5);

	}
	
	

	//	methods
	public void Enrol(String[] course) {
		
			Courses = Courses + "\n			" + StringUtils.join(course,"\n");
			tuitionBalance = tuitionBalance + CourseCost;
		

	}

	public void payFee() {
		int amount;
		Scanner in = new Scanner(System.in);
		viewBal();
		System.out.print("Enter your payment:  " + "$");
		amount = in.nextInt();
		tuitionBalance = tuitionBalance - amount;
		System.out.println("Thank you for your payment of $" + amount);
		viewBal();

	}

	//	check balance
	public void viewBal() {
		System.out.println("Outstanding balance: " + "$" + tuitionBalance);

	}

	public void showCourses() {
		System.out.println("Course");
		System.out.println(Courses);
	}

	@Override
	public String toString() {
		System.out.println("toString");
		return "Name: " + name + "\n"
				+ "SSN: " + SSN + "\n"
				+ "EMAIL: " + email + "\n"
				+ "Student ID:		" + user_id + "\n"
				+ "Courses Enrolled:" + Courses + "\n" + "\b"
				+ "Outstanding Balance:	" + "$" + tuitionBalance + "\n";
	}

	void Enrol(String math101) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	void Enrol(String math101) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	void enroll(String math101) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	void Enrol(String math101) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	void Enrol() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
