package edu.buffalo.search;

import java.util.Random;

import edu.buffalo.util.Util;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("********Binary SORT**********");
		Integer[] listToSort = Util.generateSortedArray();
		int length = listToSort.length;
		Random random = new Random();
		int searchValue = random.nextInt(10);
		System.out.println("Searching for: "+searchValue);
		int lowIndex = 0;
		int highIndex = length-1;
		while(lowIndex<=highIndex){
			int midIndex = (lowIndex+highIndex)/2;
			int midValue = listToSort[midIndex];
			if(midValue>searchValue){
				highIndex = (midIndex-1);
			}
			else if(midValue<searchValue){
				lowIndex = (midIndex+1);
			}
			else{
				System.out.println("Found the value: "+searchValue+" at index: "+midIndex);
				break;
			}
		}

	}

}
