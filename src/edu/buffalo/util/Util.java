/**
 * 
 */
package edu.buffalo.util;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Praveen Kumar Bellam
 * @EmailAddress pbellam@buffalo.edu
 */
public class Util {
	static int sortListSize = 10;
	public static Integer[] generateRandomArray(){
		// Usually this can be a field rather than a method variable
	    //Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    //int randomNum = rand.nextInt((max - min) + 1) + min;
		Random random = new Random();
		ArrayList<Integer> tempList = new ArrayList<>();
		int count = 0;
		while(count<sortListSize){
			tempList.add(random.nextInt(10)+5);
			count++;
		}
		System.out.println(tempList);
		return tempList.toArray(new Integer[tempList.size()]);
	}
	public static Integer[] generateRandomArray(int size){
		sortListSize = size;
		return generateRandomArray();
	}
	public static Integer[] generateSortedArray(){
		ArrayList<Integer> tempList = new ArrayList<>();
		for(int i=0;i<sortListSize;i++){
			tempList.add(i);
		}
		System.out.println(tempList);
		return tempList.toArray(new Integer[tempList.size()]);
	}
	public static void printIntArray(Integer[] a1){
		for(int i=0;i<a1.length;i++){
			if(a1[i] == -1){
				continue;
			}
			System.out.println(a1[i]);
		}
	}
	
	public static boolean isPrimeNumber(int val){
		if(val%2 == 0){
			return false;
		}
		else{
			for(int i=3;i*i<=val;i=i+2){
				if(val%i == 0){
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static int getNextPrime(int val){
		for(int i=val+1;true;i++){
			if(isPrimeNumber(i)){
				return i;
			}
		}
	}
	public static long findFactorial(int n){
		if(n == 0){
			return 1;
		}
		return n*findFactorial(n-1);
	}

}
