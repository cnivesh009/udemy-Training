/*
 *  @author		: Nivesh Chandola
 *  Created on	: 11/08/2019, 12:02:36 AM
 *  Program		: Sets	
 *  Last Edited	: 11/08/2019
 */
/// HashSet class implements the Set interface, supported by a hash table an
///	instance of HashMap. 
///	Features of HasSet:
///		* Implements Set Interface
///		* Underlying data structure for HashSet is hashtable
///		* Duplicate values are not allowed
///		* Objects that are inserted in HashSet are not guaranteed to be inserted
///		  in same order
///		* Objects inserted are based on their hash code
///		* NULL elements are allowed in HashSet.
///		* HashSet also implements Serializable and Cloneable interfaces
package datastructures;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {

	public static void main(String[] args) {
		
		
		
		
		Set<String> animals = new HashSet<String>(); //	polymorphism
		animals.add("fish");
		animals.add("Snake");
		animals.add("hare");
		animals.add("tiger");
		animals.add("lion");
		animals.add("pig");
		System.out.println("Animals: "+animals + "; " + animals.size() + " elements");
		
		// create new set for comparison
		Set<String> farmAnimals = new HashSet<String>(); //	polymorphism
		farmAnimals.add("chicken");
		farmAnimals.add("horse");
		farmAnimals.add("dog");
		farmAnimals.add("goat");
		farmAnimals.add("pig");
		System.out.println("Farm Animals: " + farmAnimals);
		System.out.println();
		
		//	intersection between farmAnimals and animals
		//	1. copy animals to IntersectionSet
		Set<String> IntersectionSet = new HashSet<String>(animals);
				
		//	2. retain only the elements that are also in the other set
		IntersectionSet.retainAll(farmAnimals);
		System.out.println("Intersection of farmAnimals and animals: "+ IntersectionSet);
		
		//	3. union
		Set<String> unionSet = new HashSet<String>(farmAnimals);
		unionSet.addAll(animals);
		System.out.println("The union of farmAnimals and animals: " + unionSet);
		
		//	4. difference
		Set<String> differenceSet1 = new HashSet<String>(animals);
		differenceSet1.removeAll(farmAnimals);
		System.out.println("The difference of animals and farmAnimals: " + differenceSet1);
		
		Set<String> differenceSet2 = new HashSet<String>(farmAnimals);
		differenceSet2.removeAll(animals);
		System.out.println("The difference of farmAnimals and animals: " + differenceSet2);
	
		Set<String> carnivores = new LinkedHashSet<String>();
		carnivores.add("leopard");
		carnivores.add("lion");
		carnivores.add("wolf");
		carnivores.add("tiger");
		System.out.println();
		System.out.println("LinkedHashSet lists elements in order; the order the elements are listed");
		System.out.println("Carnivores: "+ carnivores + "\n");
		
		
		HashSet<String> mammals = new HashSet<String>(carnivores);
		System.out.println("HashSet lists elements in random order");
		System.out.println("Mammals: " + mammals + "; " + mammals.size() + " elements" + "\n");
		
		Set<String> carnivoreSet = new TreeSet<>(carnivores);
		System.out.println("TreeSet lists elements in alphabetical order");
		System.out.println("Carnivores: " + carnivoreSet);
	}
}
