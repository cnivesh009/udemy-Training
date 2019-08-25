/**
 *    Document   : Maps
 *    Created on : 11/08/2019, 1:48:44 PM
 *    Author     : Nivesh-GC
 */

// Maps are key value pairs	
package datastructures;

import java.util.Map;
import java.util.TreeMap;

public class Maps {

	public static void main(String[] args) {
		//	implement 
		Map<Integer, String> hMap = new TreeMap<Integer, String>();
		mapUtil(hMap);
	}

	public static void mapUtil(Map<Integer, String> map) {
		//	add key values
		map.put(101, "Steve");
		map.put(202, "Camille");
		map.put(217, "Nivesh");
		map.put(900, "Theo");
		map.put(909, "Alex");
		map.put(512, "Pauline");

		//	access element
		System.out.println("See all the keys: " + map.keySet());
		System.out.println("See key value pairs: " + map);
		System.out.println(map.get(202));

		//	iterate through map of key value pairs
		int i = 1;	// this has to be outside
		for (int key : map.keySet()) {

			System.out.println("Key" + (i++) + ": " + key + " " + map.get(key));

		}

	}
}
