/*
 * @author	: Nivesh Chandola
 * Created on   : 22/07/2019
 * Program      : Fibonacci Series
 * Last Edited  : 10/08/2019
 */
package basics;

public class FibonacciApp {

	public static void main(String[] args) {
		//	fib(0) = 0
		//	fib(1) = 1
		//	fib(2) = fib(1) + fib(0) = 1
		//	fib(3) = fib(2) + fib(1) + fib(0) = 2
		//	fib(4) = fib(3) + fib(2) + fib(1) + fib(0) = 3
		//	fib(5) = fib(4) + fib(3) + fib(2) + fib(1) + fib(0) = 5
		System.out.println("***Fibonacci***");
		System.out.println(fibonacci(5));
	}

	public static int fibonacci(int n) {
		/// this is recursion
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return (fibonacci(n - 1) + fibonacci(n - 2));
	}

}
