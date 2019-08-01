/*
 * @author:        Nivesh Chandola
 * Date:           01.08.2019
 * Program:        File Handling
 * Last Edited:    01.08.2019
 */

package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Read{
    public static void main(String[] args){
		String text = null;
		//	1. define the file path
		String filename = "C:\\Users\\Nivesh-GC\\Documents\\Udemy\\Udemy Java\\Java Junior Dev\\Files\\FileToRead.txt";
		
		//	2. create a new file in java
		File fileObj = new File(filename);
		
		BufferedReader brObj;
		try {
			//	3. open the file
			brObj = new BufferedReader(new FileReader(fileObj));
		
			//	4. read the file
			text = brObj.readLine();
			
			//	5. close the file
			brObj.close();
		}catch (FileNotFoundException ex) {
			System.out.println("Error: File not found!!" + filename);
			ex.printStackTrace();
		}
		
		catch (IOException ex) {
			System.out.println("Error: Could not read the data");
			ex.printStackTrace();
		}finally{
			System.out.println("Finished reading the file...");
		}
		System.out.println("Text in the File: " + text);
    }
}
