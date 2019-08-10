/*
 * @author	: Nivesh Chandola
 * Created on 	: 01/08/2019
 * Program	: Data Structures - Arrays
 * Last Edited	: 10/08/2019
 */
package datastructures;

public class Arrays {

	public static void main(String[] args) {
		String str = " ";
		String[] alphabet = {"a", "b", "c", "d", "e", "f"};
		System.out.println("String[] alphabet = {\"a\", \"b\", \"c\", \"d\", \"e\", \"f\"};");
		System.out.println("The old fashioned way of using for loop:");
		System.out.println("for (int i = 0; i < 5; i++){	// when size is known");
		System.out.println("  System.out.println(alphabet[i] + \" \");\n}");
		for (int i = 0; i < 5; i++) {
			System.out.print(alphabet[i] + " ");
		}

		System.out.println("\nAn alternative of using for loop:");
		System.out.println("for(int i = 0; i < alphabet.length; i++){	// when size is not known");
		System.out.println("   System.out.print(alphabet[i]" + " + " + "\" \"" + ");" + "\n}");
		for (int i = 0; i < alphabet.length; i++) {
			System.out.print(alphabet[i] + " ");
		}
		System.out.println();

		System.out.println("Using Enhanced For Loop: ");
		System.out.println("for(String letter : alphabet){");
		System.out.println("   System.out.print(letter + \" \");\n}");
		for (String letter : alphabet) {
			System.out.print(letter + " ");
		}
		
		System.out.println();
	}
}
