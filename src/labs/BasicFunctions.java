/**
 *    Document   : BasicFunctions
 *    Created on : 24/08/2019, 12:28:34 PM
 *    Author     : Nivesh-GC 
 */

//------------------------------------------------------------------------------
/*
		1.	Write a function that takes a value n returns the sum of numbers 1 to n
		2.	Write a function that computes the factorial value Definition: n! = n*(n-1)!:
				i.		0! = 1 1! = 1	ii.	2! = 2 * 1!
				iii.	3! = 3 * 2!		iv.	4! = 4 * 3!
				Hint: use the recursive method that was used to calculate 
				Fibonnaci number
		3.	Write 3 functions that take an array as a parameter and return the 
			minimum, average, and maximum values of that array. Hint: this should
			be static functions with a return type of the same data type as the 
			array declaration
 */
//------------------------------------------------------------------------------
package labs;

import java.util.Scanner;

public class BasicFunctions {

	public static void main(String[] args) {
		int ch, num, fact, sum;
		Scanner sc = new Scanner(System.in);

		System.out.println("------------------Basic functions------------------");
		System.out.println("1. Sum of 1 to n numbers" + "\n" + "2. Factorial" + "\n"
				+ "3. Min/Avg/Max in a given array");
		System.out.print("Enter your choice: ");
		ch = sc.nextInt();
		if (ch == 1) {
			System.out.println("*****Sum of 1 to n numbers*****");
			System.out.print("Enter the value of 'n': ");
			num = sc.nextInt();
			sum = summation(num);
			if (sum != 0) {
				System.out.println("Sum of 1 to " + num + " numbers = " + sum);
			} else {
				System.out.println("Enter the value of 'n' greater than 0 ");
			}

		} else if (ch == 2) {
			System.out.println("*****Factorial Calculation*****");
			System.out.print("Enter the number: ");
			num = sc.nextInt();
			fact = factorial(num);
			System.out.println("Factorial of " + num + " = " + fact);
		} else if (ch == 3) {
			int[] arr = new int[]{20, 98, -100, 200, 1000, 10, 5, 4, 31};  //this is array literal
			int min, avg, max;
			/// size is known in array literal
			min = Minimum(arr);
			avg = Average(arr);
			max = Maximum(arr);
			System.out.println("*****Displays Mini Avg and Max Values*****");
			System.out.println("Array in the system: ");
			System.out.print("{");
			//enhanced for loop
			for (int Array : arr) {
				System.out.print(Array + " ");
			}
			System.out.print("\b" + "}");
			System.out.println();
			System.out.println("Minimum value: " + min);
			System.out.println("Average value: " + avg);
			System.out.println("Maximum value: " + max);

		}
	}

//	Summation of n numbers
	public static int summation(int num) {
		/// recursion method 
		if (num != 0) {
			num = num + summation(num - 1);
			return num; //  terminating condition
		} else {
			return num;	//  terminating condition
		}
	}

	//	factorial
	public static int factorial(int num) {
		// recursion
		int fact;
		if (num == 0) {
			return 1;
		} else {
			fact = num * factorial(num - 1);
			return fact;
		}
	}

	//	min, avg, max
	public static int Minimum(int[] arr) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	public static int Average(int[] arr) {
		int avg, total = 0;
		float dVal;
		for (int i = 0; i < arr.length; i++) {
			total = total + arr[i];
		}
		dVal = total / arr.length;
		avg = (int) (dVal);  // casting
		return avg;
	}

	public static int Maximum(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

}
