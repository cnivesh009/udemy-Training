/*
 * @author:        Michael Dohse
 * Date:           02.08.2019
 * Program:        Exception and File Handling
 * Last Edited:    02.08.2019 (using alt + shift + f)
 */
package UdemyLabsOtherStudents;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

import java.util.ArrayList;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class PasswordValidateApp {

	public static void main(String[] args) {

		/*

* 1. Read a file that contains multiple sets of passwords (use http://www.theonegenerator.com/ to generate a set of test data)



2. Verify that the password contains all of the following criteria:

1. A number

2. A letter

3. Special character (! @ #)

3. Create three User Defined Exceptions for the corresponding criteria.

4. If the password does not meet the criteria, create and throw the appropriate exception

		 */
		String[] phoneList = new String[13];

		String filePath = "C:/Users/Nivesh-GC/Documents/Udemy/Udemy Java/Java Junior Dev/Files/Passwords.txt";

		File file = new File(filePath);

		try {

			BufferedReader bf = new BufferedReader(new FileReader(file));

			for (int i = 0; i < phoneList.length; i++) {

				phoneList[i] = bf.readLine();

			}

			bf.close();

		} catch (FileNotFoundException e) {

			System.out.println("ERROR: File was not found." + filePath);

		} catch (IOException e) {

			System.out.println("ERROR: Unable to read data.");

			e.printStackTrace();

		}

		for (String j : phoneList) {

			boolean num = false;

			boolean alpha = false;

			boolean spec = false;

			for (int k = 0; k < j.length(); k++) {

				if (Pattern.compile("[0-9]").matcher(j.substring(k, k + 1)).matches()) {

					num = true;

				}

				if (Pattern.compile("\\W").matcher(j.substring(k, k + 1)).matches()) {

					spec = true;

				}

				if (Pattern.compile("[a-z A-Z]").matcher(j.substring(k, k + 1)).matches()) {

					alpha = true;

				}

			}

			try {

				if (!num) {

					throw new numberException(j);

				}

				if (!spec) {

					throw new specialCharException(j);

				}

				if (!alpha) {

					throw new alphaException(j);

				}

				System.out.println(j);

			} catch (numberException e) {

				System.out.println("ERROR: Passwrods must have at least one number.");

				System.out.println(e.toString());

			} catch (specialCharException e) {

				System.out.println("ERROR: Passwords must have at least one special character.");

				System.out.println(e.toString());

			} catch (alphaException e) {

				System.out.println("ERROR: Passwords must have at least one letter.");

				System.out.println(e.toString());

			}

		}

	}

}

class numberException extends Exception {

	String pass;

	public numberException(String pass) {

// TODO Auto-generated constructor stub
		this.pass = pass;

	}

	public String toString() {

		return "numberException: " + pass;

	}

}

class alphaException extends Exception {

	String pass;

	public alphaException(String pass) {

// TODO Auto-generated constructor stub
		this.pass = pass;

	}

	public String toString() {

		return "alphaException: " + pass;

	}

}

class specialCharException extends Exception {

	String pass;

	public specialCharException(String pass) {

// TODO Auto-generated constructor stub
		this.pass = pass;

	}

	public String toString() {

		return "specialCharException: " + pass;

	}

}
