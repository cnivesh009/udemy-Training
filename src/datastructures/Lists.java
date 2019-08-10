/*
 * @author	Nivesh Chandola
 * Created on	10/08/2019, 6:08:38 PM           
 * Program      Lists   
 * Last Edited  10/08/2019   
 */

package datastructures;

import java.util.ArrayList;

public class Lists {
    public static void main(String[] args) { 
		//	create a collection
		ArrayList<String> cities = new ArrayList<String>();

		//	add some elements
		cities.add("Clevland");
		cities.add("New Delhi");
		cities.add("Haldwani");

		//	iterate collections
		for (String city : cities) {
			System.out.println(city);
		}
		
		//	get the size
		int size = cities.size();
		System.out.println("There are " + size + " elements in the list");
		
		//	retrieve specific element
		System.out.println(cities.get(1) + " is 2nd element");		
		
		//remove element
		cities.remove(0);
		size = cities.size();
		System.out.println("Now there are " + size + " elements in the list");
    }
}
