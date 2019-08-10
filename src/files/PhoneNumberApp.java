/*
 * @author        Nivesh Chandola
 * Date           01/08/2019
 * Program        Phone Number App
 * Last Edited    10/08/2019
 */

 /* This program will read a text file and will retrieve phonenumber
	valid phone number has: 
		10 digit long
		cannot start with 0 or 9
		cannot have 911	(or 100)
 */
package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PhoneNumberApp {

	public static void main(String[] args) {
		String fname = "C:/Users/Nivesh-GC/Documents/Udemy/Udemy Java/Java Junior Dev/Files/PhoneNumber.txt";
		File fobj = new File(fname);
		String[] phoneNums = new String[9];
		String phoneNum;

		try {
			BufferedReader br = new BufferedReader(new FileReader(fobj));
			for (int i = 0; i < phoneNums.length; i++) {
				phoneNums[i] = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Error: file not found");
		} catch (IOException ex) {
			System.out.println("Error: could not read file");
		}

		for (String phoneNum1 : phoneNums) {
			phoneNum = phoneNum1;
			try {
				if (phoneNum.length() != 10) {
					throw new TenDigitException(phoneNum);
				}
				if (phoneNum.substring(0, 1).equals("3") || phoneNum.substring(0, 1).equals("7")) {
					throw new AreaCodeException(phoneNum);
				}
				for (int n = 0; n < phoneNum.length() - 2; n++) {
					if (phoneNum.substring(n, n + 1).equals("1")) {
						if (phoneNum.substring(n + 1, n + 3).equals("00")) {
							throw new EmergencyException(phoneNum);
						}
					}
				}
				System.out.println("Phone number: " + phoneNum);
			} catch (TenDigitException e) {
				System.out.println("Error: Phone number is not 10 digit");
				System.out.println(e.toString());

			} catch (AreaCodeException e) {
				System.out.println("Error: Phone number has invalid area code");
				System.out.println(e.toString());

			} catch (EmergencyException e) {
				System.out.println("Error: Invalid phone number, 100 sequence found");
				System.out.println(e.toString());
			}
		}
	}
}

class TenDigitException extends Exception {

	String num;

	TenDigitException(String num) {
		this.num = num;
	}

	//	toString() is predefined, but when used in User Defined Exception, then @Override is used
	@Override
	public String toString() {
		return ("TendDigitException: " + num);
	}
}

class AreaCodeException extends Exception {

	String num;

	AreaCodeException(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return ("AreaCodeException: " + num);
	}
}

class EmergencyException extends Exception {

	String num;

	EmergencyException(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return ("EmergencyCodeExeception: " + num);
	}
}
