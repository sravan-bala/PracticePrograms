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
public class MergeSort {
	public Integer[] merge(Integer[] left, Integer[] right) {
		//System.out.println("Left input to merge is: "+Arrays.asList(left));
		//System.out.println("Right input to merge is: "+Arrays.asList(right));
		Integer[] result = new Integer[left.length + right.length];
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				result[k] = left[i];
				i++;
			} else {
				result[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < left.length) {
			result[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			result[k] = right[j];
			j++;
			k++;
		}
		return result;
	}

	public Integer[] mergeSort(Integer[] input) {
		int arraySize = input.length;
		if(arraySize == 1){
			return input;
		}
		int midIndex = arraySize / 2;
		//System.out.println("Input to mergeSort is: "+Arrays.asList(input));
		//System.out.println("Mid Index is: "+midIndex+" arraySize is: "+arraySize);
		Integer[] leftArray = Arrays.copyOfRange(input, 0, midIndex);
		System.out.println("Left Array is: "+Arrays.asList(leftArray));
		Integer[] rightArray = Arrays.copyOfRange(input, midIndex, arraySize);
		System.out.println("Right Array is: "+Arrays.asList(rightArray));
		leftArray = mergeSort(leftArray);
		rightArray = mergeSort(rightArray);
		return merge(leftArray, rightArray);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("********MERGE SORT**********");
		Integer[] listToSort = Util.generateRandomArray(20);
		MergeSort merge = new MergeSort();
		listToSort = merge.mergeSort(listToSort);
		System.out.println(Arrays.asList(listToSort));

	}

}
