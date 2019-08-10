/*
 * @author        Nivesh Chandola
 * Date           31/07/2019
 * Program        Exception
 * Last Edited    10/08/2019
 */

package exceptions;

public class Demo{
    public static void main(String[] args){
        int a = 5;
	int b = 0;
	System.out.println("Why Error Handling is necessay?");
	doMath(a,b);
    }
    
    public static void doMath(int a, int b){
	answer(a,b);	
    }
    
    public static void answer(int x, int y){
	int c = x/y;
	System.out.println("Result of " + x + "/"+ y + " = " + c);
//	return 0;
    }

}
