/*
 *  @author		: Nivesh Chandola
 *  Created on	: 18/08/2019, 7:25:12 PM
 *  Program		: Student Database	
 *  Last Edited	: 18/08/2019
 */
package labs;

import java.util.Scanner;

public class StudentDataBase {

	public static void main(String[] args) {
		StudentDet St_1 = new StudentDet("Nivesh Chandola", "102874698");
		StudentDet St_2 = new StudentDet("Harsh Chandola", "102874698");
		StudentDet St_3 = new StudentDet("James Lye", "102874698");

		St_1.Enrol("Math101");
		St_1.Enrol("CompSc101");
		St_1.Enrol("Physics101");
		St_1.showCourses();
		St_1.payFee();
		St_1.setPhone("0413953365");
		St_1.setCity("Melbourne");
		St_1.setState("Vicotria");
		System.out.println(St_1.toString());
	}
}

class StudentDet {

	//	set private static id and encapsulation
	private static int id = 1000;
	private String user_id;
	private String name;
	private String SSN;
	private String email;
	private static String Courses = "";
	private static final int CourseCost = 600;
	private int tuitionBalance = 0;
	private String phone;
	private String city;
	private String state;

	public StudentDet(String name, String SSN) {
		id++;

		//	constructor takes New student's name and SSN
		this.name = name;
		this.SSN = SSN;

		setUserId();
		setEmail();

	}
	
	/*-----------Setters-----------*/
	
	//	generate email based on name
	private void setEmail() {
		//	\\s+ replaces all whitespaces with "" (no spaces)
		email = name.replaceAll("\\s+", "").toLowerCase() + "@student.edu.au";
	}

	//	generate user id
	private void setUserId() {
		//	user id = static id + rand 4 digit number (1k-9K)+ last 4 digit of SSN
		int max = 9000, min = 1000;
		int rNum = (int) (Math.random() * (max - min));
		user_id = id + "" + rNum + SSN.substring(5);
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	/*-----------Getters-----------*/
	public String getEmail() {
		return email;
	}

	public String getUserId() {
		return user_id;
	}
	
	public String getPhone() {
		return phone;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	/*---------------methods---------------*/
	//	enrol
	public void Enrol(String course) {

		this.Courses = this.Courses + " " + course;
		tuitionBalance = tuitionBalance + CourseCost;
	}

	//	pay fees
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

	//	show courses
	public void showCourses() {
		System.out.print("Courses offered:");
		System.out.println(Courses);
	}

	@Override
	public String toString() {
		System.out.println("\n------------Student Details------------");
		return "Name		: " + name + "\n"
				+ "SSN		: " + SSN + "\n"
				+ "EMAIL		: " + getEmail() + "\n"
				+ "Student ID	: " + getUserId() + "\n"
				+ "Phone number	: " + getPhone() + "\n"
				+ "City		: " + getCity() + "\n"
				+ "State		: " + getState() + "\n"
				+ "Courses Enrolled:" + Courses + "\n"
				+ "Outstanding Balance:	" + "$" + tuitionBalance + "\n";
	}
}
