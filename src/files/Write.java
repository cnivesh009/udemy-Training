/*
 * @author      : Nivesh Chandola
 * Created on	: 01/08/2019
 * Program      : Write data to file
 * Last Edited  : 10/08/2019
 */
package files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {

	public static void main(String[] args) {
		//	1. define the path	(for path, use \\ or /)
		String filename = "C:/Users/Nivesh-GC/Documents/Udemy/Udemy Java/Java Junior Dev/Files/FileToWrite.txt";
		String message = "Data written from Java";

		//	2. create the file in java
		File fobj = new File(filename);

		//	3. open the file
		FileWriter fw;

		try {
			fw = new FileWriter(fobj);

			//	4. write to the file
			fw.write(message);

			//	5. close the resource
			fw.close();
		} catch (IOException ex) {
			System.out.println("Error: Could not create the file " + filename);
			ex.printStackTrace();
		} finally {
			System.out.println("Closing the file...");
		}
	}
}
