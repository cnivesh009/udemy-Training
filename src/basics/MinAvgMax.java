/*
 * @author:        Nivesh Chandola
 * Date:           22.07.2019
 * Program:        Array of numbers; Displays Min, Avg and Max
 * Last Edited:    31.07.2019
 */

package basics;

public class MinAvgMax{
    public static void main(String[] args){
	int min, avg, max;
	int[] arr = new int[] {20,10,5,4,31};  //this is array literal
	/// size is known in array literal
	min = Minimum(arr);
	avg = Average(arr);
	max = Maximum(arr);
	System.out.println("*****Displays Mini Avg and Max Values*****");
        System.out.println("Minimum value: " + min);
	System.out.println("Average value: " + avg);
	System.out.println("Maximum value: " + max);
    }
    
    public static int Minimum(int[] arr){
	int min = arr[0];
	for(int i = 0; i < arr.length; i++){
	    if(arr[i] < min)
		min = arr[i];
	}
	return min;	
    }
    
    public static int Average(int[] arr){
	int avg, total = 0;
	float dVal;
	for(int i = 0; i < arr.length; i++){	    
	    total = total + arr[i]; 
	}
	dVal = total/arr.length;
	avg = (int)(dVal);  // casting
	return avg;
    }
	
    
    public static int Maximum(int[] arr){
	int max = arr[0];
	for(int i = 0; i < arr.length; i++){
	    if(arr[i] > max)
		max = arr[i];
	}
	return max;
    }
}
