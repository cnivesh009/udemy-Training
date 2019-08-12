/*
 *  @author		: Nivesh Chandola
 *  Created on	: 11/08/2019, 8:28:42 PM
 *  Program		: Algorithms Demo 	
 *  Last Edited	: 12/08/2019
 */
package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {

	static int[] number = {96, 97, 86, 79, 58, -1, 0, 2, 5, 8, 9, 52, 100};
	static int num_search = -1;

	public static void main(String[] args) {
		System.out.println("Welcome to Search Algorithm");
		System.out.println("Select from\n" + "1. Binary Search \n" + "2. Linear Search");
		System.out.print("Enter your choice(1/2): ");
		Scanner in = new Scanner(System.in);
		int ch = in.nextInt();
		if (ch == 1) {
			BinSearch();
		} else {
			LinSearch();
		}
	}

	public static void LinSearch() {
		//	call function to perform linear search
		System.out.println("Linear search operation is selected");
		int pos = algorithms.SearchAlgorithm.LinearSearch(number, num_search);
		if (pos == -1) {
			System.out.println("Number not found.");
		} else {
			System.out.println("Number found at pos: " + (pos + 1));
		}
	}

	public static void BinSearch() {

		int index;

		Arrays.sort(number);

		System.out.println("\nBinary Search works on sorted array\n");
		System.out.println("Elements are sorted first");
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}

		index = algorithms.SearchAlgorithm.BinarySearch(number, num_search, 0, number.length);
		if (index == -1) {
			System.out.println("\nNumber not found...");
		} else {
			System.out.println("\nNumber found at pos: " + (index + 1));
		}
	}
}
