/**
 *    Document   : SearchAlgorithm
 *    Created on : 11/08/2019, 8:23:50 PM	
 *    Author     : Nivesh-GC
 */

//---------Program: LinearSearch, BinarySearch works with main Class Demo
package algorithms;

public class SearchAlgorithm {

	public static int LinearSearch(int[] dataSet, int target) {
		//	iterate through data set
		for (int i = 0; i < dataSet.length; i++) {
			if (dataSet[i] == target) {
				return i;
			}
		}
		return 0;
	}

	//	recursion method is used
	public static int BinarySearch(int[] dataSet, int target, int start, int end) {
		//	binary search works on sorted array

		//	end, start and mid will vary because of recursion
		if (end >= start) {
			int mid = start + (end - start) / 2;

			if (target == dataSet[mid]) {
				return mid;
			}

			// If element is smaller than mid, then it can only 
			// be present in left subarray 
			if (target < dataSet[mid]) {
				return BinarySearch(dataSet, target, start, mid - 1);
			}

			// Else the element can only be present in right 
			// subarray 
			return BinarySearch(dataSet, target, mid + 1, end);
		}

		// We reach here when element is not present in array 
		return -1;
	}
}
