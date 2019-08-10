/*
 * @author		: Nivesh Chandola
 * Created on	: 10/08/2019, 3:44:14 PM           
 * Program		: Sets   
 * Last Edited	: 10/08/2019
 */
/// HashSet class implements the Set interface, supported by a hash table,
/// which is actually an instance of HashMap.
///	Few important features of HashSet are:
///		* Implements Set Interface
///		* Underlying data structure for HashSet is hashtable
///		* Duplicate values are not allowed
///		* Objects inserted in HashSet are not guaranteed to be inserted in same order 
///		* Objects inserted, are based on their hash code
///		* NULL elements are allowed in HashSet
///		* HashSet also implements Serializable and Cloneable interfaces
package datastructures;

import java.util.HashSet;

public class Sets {

	public static void main(String[] args) {
		//	define the collection
		HashSet<String> animals = new HashSet<String>();
		animals.add("pig");
		animals.add("hare");
		animals.add("lion");
		animals.add("tiger");
		System.out.println(animals + "; " + animals.size() + " elements");
		animals.add("fish");
		animals.add("snake");
		animals.add("tiger");
		System.out.println(animals + "; " + animals.size() + " elements");
		
		//	create set for comparison
		
		
	}
}

