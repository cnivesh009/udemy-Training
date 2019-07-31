/*
 * @author:        Nivesh Chandola
 * Date:           30.07.2019
 * Program:        Revision
 * Last Edited:    30.07.2019
 */

package oop;

class Person{
    String name;
    String email;
    String phNum;
    
    void walk(){
	System.out.println(name + " is walking.");	
    }
    
    void eat(){
	System.out.println(email);	
    }
    
    void sleep(){
	System.out.println(name + " is sleeping.");	
    }
}

public class Demo{
    public static void main(String[] args){
        Person person1 = new Person();
	person1.name = "Nivesh Chandola";
	person1.email = "cnivesh@hotmail.com";
	person1.phNum = "0413953365";
	
	Person person2 = new Person();
	person2.name = "Harsh Chandola";
	person2.email = "chandolahc@hotmail.com";
	person2.phNum = "8395078068";
	
	/// Abstraction
	person1.walk();
	person1.eat();
	person1.sleep();
	
	person2.walk();
	person2.eat();
	person2.sleep();
	
    }

}
