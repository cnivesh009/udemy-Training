/*
 *  @author		: Nivesh Chandola
 *  Created on	: 12/08/2019, 4:55:52 PM
 *  Program		: Bubble Sort	
 *  Last Edited	: 12/08/2019
 */
package algorithms;

class Sort {

	public static void bubbleSort(int[] dataSet) {
		System.out.print("Unsorted Array: ");
		displayArr(dataSet);
		int pass = 1;
		do {
			for (int i = 0; i < (dataSet.length - 1 - pass); i++) {

				if (dataSet[i] > dataSet[i + 1]) {
					int tmp = dataSet[i];
					dataSet[i] = dataSet[i + 1];
					dataSet[i + 1] = tmp;
				}
			}
			pass++;
		} while (pass <= dataSet.length - 1);
		System.out.print("\n" + "Sorted Array: ");
		displayArr(dataSet);
		System.out.println();

	}

	private static void displayArr(int[] arr) {
		for (int i : arr) {

			System.out.print(i + " ");
		}
	}
}
