/**
 *    Document   : Factorial
 *    Created on : 22/07/2019, 6:31:11 PM
 *    Author     : Nivesh-GC
 */
package basics;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		int num, fact;
		Scanner sc = new Scanner(System.in);
		System.out.println("*****Factorial Calculation*****");
		System.out.print("Enter the number: ");
		num = sc.nextInt();
		fact = factorial(num);
		System.out.println("Factorial of " + num + " = " + fact);
	}

	public static int factorial(int num) {
		/// recursion
		int fact;
		if (num == 0) {
			return 1;
		} else {
			fact = num * factorial(num - 1);
			return fact;
		}
	}
}
