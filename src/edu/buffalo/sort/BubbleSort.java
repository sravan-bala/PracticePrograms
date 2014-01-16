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
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("********Bubble SORT**********");
		Integer[] listToSort = Util.generateRandomArray();
		int length = listToSort.length;
		for(int i=(length-1);i>0;i--){
			for(int j=0;j<i;j++){
				if(listToSort[j]>listToSort[j+1]){
					int temp = listToSort[j];
					listToSort[j] = listToSort[j+1];
					listToSort[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.asList(listToSort));

	}

}
