/**
 * 
 */
package edu.buffalo.sort;

import java.util.Arrays;
import edu.buffalo.util.Util;

/**
 * @author Praveen Kumar Bellam
 * @EmailAddress pbellam@buffalo.edu
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] listToSort = Util.generateRandomArray();
		int unSortIndex = 0;
		while(unSortIndex < listToSort.length - 1){
			int currMin = listToSort[unSortIndex];
			int currMinIndex = unSortIndex;
			boolean swap = false;
			for(int i=(unSortIndex+1);i<listToSort.length;i++){
				if(listToSort[i]<currMin){
					currMin = listToSort[i];
					currMinIndex = i;
					swap = true;
				}
			}
			if(swap){
				listToSort[currMinIndex] = listToSort[unSortIndex];
				listToSort[unSortIndex] = currMin;
			}
			unSortIndex++;
		}
		System.out.println(Arrays.asList(listToSort));
	}
}
