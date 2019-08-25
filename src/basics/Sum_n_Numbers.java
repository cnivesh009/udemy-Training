/**
 *    Document   : Sum_n_Numbers
 *    Created on : 22/07/2019
 *    Author     : Nivesh-GC
 */

package basics;

import java.util.Scanner;

public class Sum_n_Numbers {
    public static void main(String[] args){
	int n, sum;
	Scanner sc = new Scanner(System.in);
	System.out.println("*****Sum of 1 to n numbers*****");
	System.out.print("Enter the value of 'n': ");
	n = sc.nextInt();
	sum = summation(n);
	if(sum != 0)
	    System.out.println("Sum of 1 to " + n + " numbers = " + sum);
	else
	    System.out.println("Enter the value of 'n' greater than 0 ");
	    
    }
    public static int summation(int num){
	/// recursion method 
	if(num != 0){
	    num = num + summation(num - 1);
	    return num; //  terminating condition
	}
	else
	    return num;	//  terminating condition
    }
}
