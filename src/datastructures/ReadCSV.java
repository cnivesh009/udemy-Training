/*
 *  @author		: Nivesh Chandola
 *  Created on	: 11/08/2019, 6:36:28 PM
 *  Program		: ReadCSV file	
 *  Last Edited	: 11/08/2019
 */
package datastructures;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

	public static void main(String[] args) throws FileNotFoundException {
		//	read a csv file
		List<String[]> data = new ArrayList<String[]>();
		String filenm = "C:\\Users\\Nivesh-GC\\Documents\\Udemy\\Udemy Java\\Java Junior Dev\\Files\\Accounts.csv";
		String dataRow;
		try {
			//	open the file
			BufferedReader br = new BufferedReader(new FileReader(filenm));
			while ((dataRow = br.readLine()) != null) {
				//	parse the data by commas
				String[] line = dataRow.split(",");

				//	add the data to the collection
				data.add(line);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		for (String[] account : data) {
			System.out.print("[");
			for (String field : account) {
				System.out.print(field + " ");
			}
			System.out.println("]");
		}
	}
}
