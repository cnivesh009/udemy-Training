/*
 * @author:        Nivesh Chandola
 * Date:           02.08.2019
 * Program:        Exceptions and file handling
 * Last Edited:    02.08.2019
 */

 /* 
   This program checks the criteria set for Password
   the password contains:
		atleast a number
		atleast a letter
		atleast a special character(ex !@#...)
   create 3 programmer defined exception for the set criteria
 */
package exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class PasswordCriteria {	//	main class

	public static void main(String[] args) throws IOException {
		String fname = "C:/Users/Nivesh-GC/Documents/Udemy/Udemy Java/Java Junior Dev/Files/Passwords.txt";
		File fobj = new File(fname);
		String[] passwords = new String[11];
		try {
			BufferedReader br = new BufferedReader(new FileReader(fobj));

			//	store content of file in an array
			for (int i = 0; i < passwords.length; i++) {
				passwords[i] = br.readLine();
			}

			br.close();	//	close file

		} catch (FileNotFoundException ex) {
			System.out.println("Error: file not found");

		} catch (IOException ex) {
			System.out.println("Error: could not read file");
		}

		//	enhanced for loop
		for (String Pass : passwords) {
			boolean Number = false;
			boolean Letter = false;
			boolean SChar = false;

			for (int i = 0; i < Pass.length(); i++) {
				if (Pattern.compile("[0-9]").matcher(Pass.substring(i, i + 1)).matches()) {
					Number = true;
				}

				if (Pattern.compile("[a-zA-Z]").matcher(Pass.substring(i, i + 1)).matches()) {
					Letter = true;
				}

				// Regex for special: \W; but in Regex \\W is used to differntiate \W from \ 
				if (Pattern.compile("\\W").matcher(Pass.substring(i, i + 1)).matches()) {
					SChar = true;
				}
			}
			try {
				if (!Number) {
					throw new NumberException(Pass);
				}

				if (!Letter) {
					throw new LetterException(Pass);
				}

				if (!SChar) {
					throw new SpecialCharException(Pass);
				}
				System.out.println(Pass);
			} catch (NumberException ex) {
				System.out.print("\nError(Number): ");
				System.out.println(ex.toString());
				System.out.println();

			} catch (LetterException ex) {
				System.out.print("\nError(Letter): ");
				System.out.println(ex.toString());
				System.out.println();

			} catch (SpecialCharException ex) {
				System.out.print("\nError(SChar): ");
				System.out.println(ex.toString());
				System.out.println();
			}
		}
	}
}

/*----------Programmer Defined Exception----------*/
class NumberException extends Exception {

	String pass;	//	class variable

	public NumberException(String pass) {
		this.pass = pass;	//	class var = local var
	}

	@Override
	public String toString() {
		System.out.println("Password should have atleast 1 number");
		return ("NumberException: " + pass);
	}
}

class LetterException extends Exception {

	String pass;

	public LetterException(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		System.out.println("Password should have atleast 1 letter");
		return ("LetterException: " + pass);
	}
}

class SpecialCharException extends Exception {

	String pass;

	public SpecialCharException(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		System.out.println("Password should have atleast 1 special character");
		return ("SpecialCharacterException: " + pass);
	}
}
