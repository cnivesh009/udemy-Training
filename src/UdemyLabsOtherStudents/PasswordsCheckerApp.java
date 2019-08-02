/*
 * @author:        Hermann DJAHA
 * Date:           02.08.2019
 * Program:        Exception and file handling
 * Last Edited:    02.08.2019
 */
package UdemyLabsOtherStudents;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

public class PasswordsCheckerApp {

	public static void main(String[] args) {

		String fileName = "C:/Users/Nivesh-GC/Documents/Udemy/Udemy Java/Java Junior Dev/Files/Passwords.txt";

		PasswordFileChecker file1 = new PasswordFileChecker(fileName);

		System.out.println(file1.toString());

//file empty
		System.out.println("\n");

		String emptyFile = "C:/Users/Nivesh-GC/Documents/Udemy/Udemy Java/Java Junior Dev/Files/passwordsFileEmpty.txt";

		PasswordFileChecker file2 = new PasswordFileChecker(emptyFile);

		System.out.println(file2.toString());

//file not exist
		System.out.println("\n");

		String fileNotExists = "C:/Users/Nivesh-GC/Documents/Udemy/Udemy Java/Java Junior Dev/Files/passwordsFileEmpty.txt";

		PasswordFileChecker file3 = new PasswordFileChecker(fileNotExists);

		System.out.println(file3.toString());

	}

}

class PasswordFileChecker {

	private String fileName;

	private String passwords = "";

	private String fileContent = "";

	private int numberOfValidPasswords = 0;

	private int numberOfFileLines = 0;

	public PasswordFileChecker(String fileName) {

		try {

			this.setFileName(fileName);

			this.readFileContent();

		} catch (FileEmptyException e) {

			e.toString();

			e.printStackTrace();

		} catch (FileNotFoundException e) {

			System.out.println("File '" + this.fileName + "' not found.");

			e.printStackTrace();

		} catch (IOException e) {

			System.out.println("File '" + this.fileName + "' does not exists.");

			e.printStackTrace();

		}

	}

	public void setFileName(String fileName) throws IOException {

		if ((fileName.equals(null)) || (fileName.isEmpty())) {
			throw new IOException();
		}

		this.fileName = fileName;

	}

	private void readFileContent() throws FileNotFoundException, IOException,
			FileEmptyException {

		File file = new File(this.fileName);

		BufferedReader br = new BufferedReader(new FileReader(file));

		if (!br.ready()) {
			throw new FileEmptyException(this.fileName);
		}

		while (br.ready()) {

			String line = br.readLine();

			try {

//Reading the file content
				this.fileContent += "\n" + line;

				this.numberOfFileLines++;

//Checking the validity of each password
				PassWord password = new PassWord(line);

				if (password.isValid()) {

					this.passwords += "\n" + password.toString();

					this.numberOfValidPasswords++;

				}

			} catch (NoNumberException e) {

				System.out.println(e.toString());

			} catch (NoLetterException e) {

				System.out.println(e.toString());

			} catch (NoSpecialCharException e) {

				System.out.println(e.toString());

			}

		}

		this.fileContent = this.fileContent.trim();

		this.passwords = this.passwords.trim();

	}

	public String showContent() {

		try {

			if (this.fileContent.equals("")) {
				throw new FileEmptyException(this.fileName);
			}

		} catch (FileEmptyException e) {

			e.toString();

		}

		return this.fileContent;

	}

	public String showValidPasswords() {

		try {

			if (this.passwords.equals("")) {
				throw new NoValidPasswordFoundException(this.fileName);
			}

		} catch (NoValidPasswordFoundException e) {

			e.toString();

		}

		return this.passwords;

	}

	public int getNumberOfPasswords() {

		return numberOfValidPasswords;

	}

	public int getNumberOfFileLines() {

		return numberOfFileLines;

	}

	@Override

	public String toString() {

		return "[ file name : " + fileName + " ]\n"
				+ "[ number of passwords in the file : " + this.numberOfFileLines + " ]\n"
				+ "[ passwords in the file : \n { " + this.showContent() + " } ]\n"
				+ "[ number of valid of passwords : " + this.numberOfValidPasswords + " ]\n"
				+ "[ Valid passwords in the file : \n { " + this.passwords + " } ]\n";

	}

}

//***** Password Class *****//
class PassWord {

	String password;

	public PassWord(String password) {

		if (!(password.equals(null)) || !(password.isEmpty())) {
			this.password = password;
		}

	}

	public boolean isValid() throws NoNumberException, NoLetterException, NoSpecialCharException {

		boolean isOk = true;

		boolean hasNumber = false;

		boolean hasLetter = false;

		boolean hasSpecialChar = false;

		for (int i = 0; i < password.length(); i++) {

			char c = password.toLowerCase().charAt(i);

// check for number
			if ((!hasNumber) && (c >= '0' && c <= '9')) {
				hasNumber = true;
			} // check for letter
			else if ((!hasLetter) && (c >= 'a' && c <= 'z')) {
				hasLetter = true;
			} // check for special character
			else if ((!hasSpecialChar) && (c == '!' || c == '@' || c == '#')) {
				hasSpecialChar = true;
			}

		}

		if (!hasNumber) {
			throw new NoNumberException(this.password);
		}

		if (!hasLetter) {
			throw new NoLetterException(this.password);
		}

		if (!hasSpecialChar) {
			throw new NoSpecialCharException(this.password);
		}

		return isOk;

	}

	@Override

	public String toString() {

		return this.password;

	}

}

//****** Lab Exceptions Classes ******//
class NoLetterException extends Exception {

	String password;

	public NoLetterException(String password) {

		this.password = password;

	}

	@Override

	public String toString() {

		return "NoLetterException : The password "
				+ this.password + " has no letter ";

	}

}

class NoNumberException extends Exception {

	String password;

	public NoNumberException(String password) {

		this.password = password;

	}

	@Override

	public String toString() {

		return "NoNumberException : The password "
				+ this.password + " has no number ";

	}

}

class NoSpecialCharException extends Exception {

	String password;

	public NoSpecialCharException(String password) {

		this.password = password;

	}

	@Override

	public String toString() {

		return "NoSpecialCharException : The password "
				+ this.password + " has none of these the special character: ! @ # ";

	}

}

//****** Lab Extra Exceptions Classes ******//
class FileEmptyException extends Exception {

	String fileName;

	public FileEmptyException(String fileName) {

		this.fileName = fileName;

	}

	@Override

	public String toString() {

		return "FileEmptyException: the file " + this.fileName + " is empty ";

	}

}

class NoValidPasswordFoundException extends Exception {

	String fileName;

	public NoValidPasswordFoundException(String fileName) {

		this.fileName = fileName;

	}

	@Override

	public String toString() {

		return "NoValidPasswordFoundException: no valid password found in " + this.fileName;

	}

}
