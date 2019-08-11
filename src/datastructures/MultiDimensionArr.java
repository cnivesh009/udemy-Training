/*
 * @author		: Nivesh Chandola
 * Created on	: 01/08/2019
 * Program		: Multi Dimension Array
 * Last Edited	: 10/08/2019
 */
package datastructures;

public class MultiDimensionArr {

	public static void main(String[] args) {
		String[][] users = {
			{"John", "Wilikinson", "jwilliams@gmail.com", "0413953365"},
			{"Nivesh", "Chandola", "cnivesh@hotmail.com", "8395078068"},
			{"Harsh", "Chandola", "chandolahc@hotmail.com", "7586278390"}
		};
		int num_of_users = users.length;
		int num_of_fields = users[0].length;
		System.out.println("Number of users: " + num_of_users);
		System.out.println("Number of fields: " + num_of_fields);

		//	traversing old fashioned
		for (int i = 0; i < num_of_users; i++) {
			String firstname = users[i][0];
			String lastname = users[i][1];
			String email = users[i][2];
			String phoneNum = users[i][3];
			System.out.println(firstname + "	" + lastname + "	" + email + "	" + phoneNum);
		}
		System.out.println();
		System.out.println("Using 2 for loops");
		for (int i = 0; i < num_of_users; i++) {
			for (int j = 0; j < num_of_fields; j++) {
				System.out.print(users[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Enhanced for loop was used for 2D arrary");
		for (String[] user : users) {	//	2d Array users converted to single array
			for (String field : user) {
				System.out.print(field + "	");
			}
			System.out.println();
		}

	}
}
