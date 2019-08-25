/**
 *    Document   : BankAccountApp
 *    Created on : 30/07/2019, 9:59:57 PM
 *    Author     : Nivesh-GC 
 */

//----------BankAccountApp works with class IInterest-----------
package labs;

public class BankAccountApp{
    public static void main(String[] args){
	BankAccount acc1, acc2, acc3;
        acc1 = new BankAccount("413953365", 1000);
	acc2 = new BankAccount("251675801", 1500);
	acc3 = new BankAccount("213285621", 250);
	
	acc1.setName("Jim");
	System.out.println("Name: " + acc1.getName());
	acc1.makeDeposit(100);
	acc1.payBill(200);
	acc1.accrue();
	System.out.println(acc1.toString());
	
    }

}

class BankAccount implements IInterest{
    //	properties of bankaccount 
    private static int ID = 1000;  //	property belongs to class notthe obj, because of static
    private String accountNumber; // id + random 2 digit number + first two digit of SSN
    private static final String routingNumber = "1929009007";
    private String name;
    private String SSN;
    private double balance;
    
    //	constructors
    public BankAccount(String SSN, double initDeposit){
//	System.out.println("New Account Created");
	balance = initDeposit;
	this.SSN = SSN;
	ID++;
//	System.out.println("Id: " + ID);
	setAccountNumber();
    }
    
    private void setAccountNumber(){
	int random = (int)(Math.random() * 100);	//  multiplying by 10 generates 1 digit number
//	System.out.println("Random: " + random);
	accountNumber = ID + "" + random + SSN.substring(0,2);	//  truncates; displays 2 digits of SSN 
	System.out.println("Your account number: "+ accountNumber);
    } 
    
    public void setName(String name){
	this.name = name;
    }
    
    public String getName(){
	return name;
    }
    
    public void payBill(double amount){
	balance = balance - amount;
	System.out.println("Balance after Bill payment");
	showBalance();
    }
    
    public void makeDeposit(double amount){
	balance = balance + amount;
	System.out.println("Balance after making a Deposit");
	showBalance();
    }
    
    public void showBalance(){
	System.out.println("Your balance: " + "$ "+ String.format("%.2f", balance));
    }

    @Override
    public void accrue() {
	balance = balance * (1 + rate/100);
	System.out.print("After Interest ");
	showBalance();
    }
    
    @Override
    public String toString(){
	return "[Name: " + name + "]\n" + "[Account Number: " + accountNumber + "]\n" + "[Routing Number: " + routingNumber + "]\n" + "[Balance: " + "$ " + String.format("%.2f",balance) + "]\n";
    }
}
