/*
 * @author:        Oxana Manishkina
 * Date:           02.08.2019
 * Program:        Exception and file handling
 * Last Edited:    02.08.2019 (using Alt + shift + f)
 */
package UdemyLabsOtherStudents;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

public class Password3 {

	public static void main(String[] args) {

// This will read a text file and will retrieve passwords
		String newFile = "C:\\Users\\Nivesh-GC\\Documents\\Udemy\\Udemy Java\\Java Junior Dev\\Files\\Passwords.txt";

		File file = new File(newFile);    //creating the java file

		String[] passwords = new String[9];

		String password = null;

		try {

			BufferedReader br = new BufferedReader(new FileReader(file)); //open the file

			for (int i = 0; i < passwords.length; i++) {

				passwords[i] = br.readLine();

				System.out.println(passwords[i]);

			}

			br.close();   //close the file

		} catch (FileNotFoundException e) {

			System.out.println("ERROR: File not found");

		} catch (IOException e) {

			System.out.println("ERROR: Could not read file");

		}

		for (int i = 0; i < passwords.length; i++) {

			password = passwords[i];

			System.out.println(PassCheck(password));

		}//for

	}//main

	public static String PassCheck(String password) {

		String result = password + " is valid password";

		int numCount = 0, letterCount = 0, specSymbol = 0;

		try {

			for (int i = 0; i < password.length(); i++) {

				if ((password.charAt(i) >= 47 && password.charAt(i) <= 58)
						|| (password.charAt(i) >= 64 && password.charAt(i) <= 91)
						|| (password.charAt(i) >= 97 && password.charAt(i) <= 122)
						|| (password.charAt(i) == '#')
						|| (password.charAt(i) == '@')
						|| (password.charAt(i) == '!')) {

				} else {

					result = password + " is not valid password";

				}

				if ((password.charAt(i) >= 47 && password.charAt(i) <= 58)) {

					numCount++;

				}

				if ((password.charAt(i) >= 64 && password.charAt(i) <= 91)
						|| (password.charAt(i) >= 97 && password.charAt(i) <= 122)) {

					letterCount++;

				}

				if ((password.charAt(i) == '#') || (password.charAt(i) == '@') || (password.charAt(i) == '!')) {

					specSymbol++;

				}

			}//for

			if (numCount < 1) {

				throw new DigitException(password);

			}

			if (letterCount < 1) {

				throw new LetterException(password);

			}

			if (specSymbol < 1) {

				throw new SpecialCharException(password);

			}

		} catch (DigitException e) {

			System.out.println("ERROR: Password must contain at least one digit");

			System.out.println(e.toString());

		} catch (LetterException e) {

			System.out.println("ERROR: Password must contain at least one letter");

			System.out.println(e.toString());

		} catch (SpecialCharException e) {

			System.out.println("ERROR: Password must contain at least one special character of ! or @ or #");

			System.out.println(e.toString());

		}

		return (result);

	}//method

}//class

class DigitException extends Exception {

	String pwd;

	DigitException(String psw) {

		this.pwd = psw;

	}

	public String toString() {

		return ("DigitException: " + pwd);

	}

}

class LetterException extends Exception {

	String pwd;

	LetterException(String pwd) {

		this.pwd = pwd;

	}

	public String toString() {

		return ("LetterException: " + pwd);

	}

}

class SpecialCharException extends Exception {

	String pwd;

	SpecialCharException(String pwd) {

		this.pwd = pwd;

	}

	public String toString() {

		return ("SpecialCharException: " + pwd);

	}

}
