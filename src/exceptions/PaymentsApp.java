/*
 * @author:        Nivesh Chandola
 * Date:           31.07.2019
 * Program:        User defined exception
 * Last Edited:    31.07.2019
 */

package exceptions;

import java.util.Scanner;

public class PaymentsApp{
    //	take payments from the user
    public static void main(String[] args){
	double payment = 0;
	boolean positivePymt = true;
	
	do{
		//  1. ask the user for input
		System.out.print("Enter the payment amount: " + "$ ");
	
		//  2. get the amount and test the value
		Scanner inp = new Scanner(System.in);
		
		//  3. handle the exceptions accordingly
		try{
			payment = inp.nextDouble();
			if(payment < 0){
			//  throw exception
			throw new NegativePaymentException(payment);
			}else{
				break;
			}
		}catch(NegativePaymentException e){
			System.out.println(e.toString());
			positivePymt = false;
		}
	}while(!positivePymt);
	
	//  4. print confirmation
		System.out.println("Thank you for your payment of $ " + String.format("%.2f",payment));
    }
}
