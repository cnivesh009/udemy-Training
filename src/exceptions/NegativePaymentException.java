/**
 *    Document   : NegativePaymentException
 *    Created on : 31/07/2019, ‏‎4:38:45 PM
 *    Author     : Nivesh-GC
 */

package exceptions;

public class NegativePaymentException extends Exception{
    double payment; //	class var
	
    //	constructor takes the value that would throw an exception
    public NegativePaymentException(double payment){
		//	assign value of local var: payment(of type double) to class var
	this.payment = payment;
    }
	
	//	override the toString method to include the specific exception message
    public String toString(){
	return "Error: Cannot take negative payment $" + String.format("%.2f", payment);
    }
}
