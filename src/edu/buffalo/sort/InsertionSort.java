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
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("********INSERTION SORT**********");
		Integer[] listToSort = Util.generateRandomArray();
		for(int i=1;i<listToSort.length;i++){
			boolean shift = false;
			int shiftToIndex = i;
			int elementToInsert = listToSort[i];
			if(listToSort[i]<listToSort[i-1]){
				shift = true;
				shiftToIndex = i-1;
				//System.out.println("Intermediate "+Arrays.asList(listToSort));
				for(int j=(i-2);j>=0;j--){
					//System.out.println("Curr J value is "+j);
					//System.out.println("Current iterating element is "+listToSort[j]+" element we are dealing with is "+elementToInsert);
					if(listToSort[j]>=elementToInsert){
						shiftToIndex = j;
					}
					else{
						break;
					}
				}
			}
			//System.out.println("For index "+i+" shift to index is "+shiftToIndex);
			if(shift){
				int tempToShift = listToSort[shiftToIndex];
				listToSort[shiftToIndex] = elementToInsert;
				//System.out.println("Shifted element "+tempToShift+" from index "+i+" to index "+shiftToIndex);
				for(int k=(shiftToIndex + 1);k<(i+1);k++){
					int anotherTemp = listToSort[k]; 
					listToSort[k] = tempToShift;
					tempToShift = anotherTemp;
				}
			}
			//System.out.println("Intermediate "+Arrays.asList(listToSort));
		}
		System.out.println(Arrays.asList(listToSort));

	}

}
