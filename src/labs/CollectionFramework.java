/**
 *    Document   : BasicFunctions
 *    Created on : 22/08/2019, 6:44:20 PM
 *    Author     : Nivesh-GC 
 */
//------------------------------------------------------------------------------
	/*
		-	Read a credit card CSV statement
		-	Creating a balance variable that calculates the running balance of 
			the user’s account
		-	If the field says CREDIT, then add the amount to the balance
		-	If the field says DEBIT, then subtract the amount to the balance
		-	If the final amount is greater than zero, charge a 10% fee and warn 
			the user
		-	If the final amount is zero, thank the user for their payments
		-	If the final amount is less than zero, thank the user for their 
			payment and display their overpayment
	*/
//------------------------------------------------------------------------------
package labs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionFramework {

	public static void main(String[] args) {
		double bal = 0;
		List<String[]> data = new ArrayList<>();
		String filenm = "C:\\Users\\Nivesh-GC\\Documents\\Udemy\\Udemy Java\\"
				+ "Java Junior Dev\\Files\\CCstatement.csv";
		String dataRow;
		try {
			//	open the file
			BufferedReader br = new BufferedReader(new FileReader(filenm));
			while ((dataRow = br.readLine()) != null) {
				//	parse the data separated by commas
				String[] line = dataRow.split(",");

				//	add the data to the collection
				data.add(line);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		for (String[] statement : data) {
			//	4 columns of the data in a .csv file
			String date = statement[0];
			String type = statement[1];
			String vendor = statement[2];
			double amnt = Double.parseDouble(statement[3]);

			System.out.print(date + "\t" + type + "\t" + vendor + "\t    \b    \t"
					+ " $ " + String.format("%.2f", amnt));

			if (type.equalsIgnoreCase("credit")) {

				bal = bal + amnt;
			} else if (type.equalsIgnoreCase("debit")) {

				bal = bal - amnt;
			} else {

			}
			System.out.println("\t" + "Balance: $" + String.format("%.2f", bal));

		}
		if (bal > 0) {
			System.out.println("Outstanding balance: " + String.format("%.2f", bal));
			System.out.println("Rate charged is 10%: $" + String.format("%.2f", bal * .1));
			
			//	new balance = balance + (10% of balance)
			System.out.println("New outstanding balance: $" + String.format("%.2f", bal * 1.1));
		} else if (bal < 0) {
			System.out.println("You have made an over payment of: $" + 
					String.format("%.2f", bal));
		} else {
			System.out.println("Thankyou for you payment:");
		}
	}
}
