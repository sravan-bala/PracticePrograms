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
public class QuickSort {
	Integer[] listToSort;
	public int partition(int left, int right){
		//System.out.println("input to partition method: left- "+left+" right- "+right);
		int size = right-left+1;
		if(size == 1){
			return 0;
		}
		int partitionIndex = left;
		int partitionElement = listToSort[partitionIndex];
		//System.out.println("Partition element is: "+partitionElement);
		int li=left,ri=right;
		int lLimit = right;
		int rLimit = left;
		while(li<ri){
			while(li<lLimit && listToSort[li]<partitionElement){
				++li;
			}
			while(ri>rLimit && listToSort[ri]>=partitionElement){
				--ri;
			}
			if(li<ri){
				//System.out.println("Swapping the value: "+listToSort[li]+" at the index "+li+" with the value: "+listToSort[ri]+" at the index "+ri);
				int temp = listToSort[li];
				listToSort[li] = listToSort[ri];
				listToSort[ri] = temp;
			}
			else if(li>ri){
				li--;
			}
			//System.out.println("Current value of left index is: "+li);
			//System.out.println("Current value of right index is: "+ri);
		}
		//displayArray(left,right);
		//System.out.println("Left index stopped at: "+li);
		return li;
	}
	public void quickSort(int left, int right){
		if(right-left<=0){
			return;
		}
		else{
			int partitionIndex = partition(left, right);
			quickSort(left,partitionIndex);
			quickSort(partitionIndex+1,right);
		}
	}
	public void sort(){
		quickSort(0,listToSort.length-1);		
	}
	public void displayArray(){
		System.out.println(Arrays.asList(listToSort));
	}
	public void displayArray(int left, int right){
		for(int i=left;i<=right;i++){
			System.out.print(listToSort[i]+" | ");			
		}
		System.out.println(" partition index is: "+left);
	}
	public int getPartitionIndex(){
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("********Quick SORT**********");
		QuickSort quikSort = new QuickSort();
		quikSort.listToSort = Util.generateRandomArray(10);
		quikSort.sort();
		quikSort.displayArray();
		
	}

}
