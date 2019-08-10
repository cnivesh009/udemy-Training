/*
 * @author      : Nivesh Chandola
 * Created on	: 31/07/2019
 * Program	: Exception
 * Last Edited	: 10/08/2019
 */

package exceptions;

public class CommonException{
    public static void main(String[] args){
	int a = 5;
	int b = 0;
        //  identify the problem 
	//  use try and catch block to solve the problem
	try{
	    int c = a/b;
	}
	catch(ArithmeticException e){
	    System.out.println("Division by zero is not possible");
	    System.out.println(e.toString());
	}
	System.out.println("Program is terminating");
	
	String[] states = {"Uttar Pradesh", "Uttarakhand", "Tamil Nadu"};
	for(int i = 0; i<=states.length; i++){
	    //	i<=...	--> sets array out of bounds
	    try{
		System.out.println(states[i]);
	    }catch(ArrayIndexOutOfBoundsException ae){
		System.out.println("Index outside of Array domain");
		System.out.println(ae.toString());
	    }finally{
		//  finally block gets executed whether the exceptionis handled or not
		//  finally block comes after try and catch
		System.out.println("Iterating through array");
	    }
	}
    }
}
