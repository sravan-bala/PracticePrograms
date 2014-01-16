/**
 * 
 */
package edu.buffalo.util;

import java.util.Arrays;

/**
 * @author Praveen Kumar Bellam
 * @EmailAddress pbellam@buffalo.edu
 */

public class CrackCodeStringQs {
	//function takes a char array as input.
	//modifies it to remove duplicates and adds a 0 to mark the end
	//of the unique chars in the array.
	public static void removeDuplicates(char[] str) {
		if (str == null)
			return; // if the array does not exist..nothing to do return.
		int len = str.length; // get the array length.
		if (len < 2)
			return; // if its less than 2..can't have duplicates..return.
		int tail = 1; // number of unique char in the array.
		// start at 2nd char and go till the end of the array.
		for (int i = 1; i < len; ++i) {
			int j;
			// for every char in outer loop check if that char is already seen.
			// char in [0,tail) are all unique.
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break; // break if we find duplicate.
			}
			// if j reachs tail..we did not break, which implies this char at
			// pos i
			// is not a duplicate. So we need to add it our "unique char list"
			// we add it to the end, that is at pos tail.
			if (j == tail) {
				str[tail] = str[i]; // add
				++tail; // increment tail...[0,tail) is still "unique char list"
			}
		}
		if(tail < len){
		   str[tail] = 0; // add a 0 at the end to mark the end of the unique char.			
		}
	}
	public static String removeDuplicateChars(String str){
		int length = str.length();
		String out = "";
		for(int i=0;i<length;i++){
			if(!out.contains(str.charAt(i)+"")){
				out = out+str.charAt(i);
			}
		}
		return out;
		/*char[] chars = str.toCharArray();
		removeDuplicates(chars);
		for(int i=0;i<str.length();i++){
			for(int j=i+1;j<str.length();j++){
				if(chars[i] == chars[j]){
					chars[j]=' ';
				}
			}
		}
		return  String.valueOf(chars);*/
	}
	public static boolean isStringWithUniqueChars(String str){
		boolean[] chars = new boolean[256]; //Total no. of characters in ASCI
		for(int i=0;i<str.length();i++){
			int val = str.charAt(i);
			if(chars[val]){
				return false;
			}
			chars[val]=true;
		}
		return true;
	}
	public static String reverseString(String str){
		char[] chars = str.toCharArray();
		for(int i=0;i<chars.length/2;i++){
			char temp = chars[i];
			chars[i] = chars[chars.length-1-i];
			chars[chars.length-1-i] = temp;			
		}
		return String.valueOf(chars);
	}
	public static boolean isAnagrams(String str1, String str2){
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		//System.out.println(char1);
		//System.out.println(char2);
		return Arrays.equals(char1, char2);
		
		/*int length1 = str1.length();
		int length2 = str2.length();
		if(length1 != length2){
			return false;
		}
		for(int i=0;i<length1;i++){
			if(str2.indexOf(str1.charAt(i)) == -1){
				return false;
			}
		}
		return true;*/
	}
	public static String removeSpacesWithPercent20(String str){
		int noOfSpaces = 0;
		int length = str.length();
		int i;
		for(i=0;i<length;i++){
			if(str.charAt(i) == ' '){
				noOfSpaces++;
			}
		}
		System.out.println("i value after for loop is: "+i);
		if(noOfSpaces != 0){
			int newLength = length + noOfSpaces*2;
			char[] chars = new char[newLength];
			int runningIndex = 0;
			for(int j=0;j<length;j++){
				if(str.charAt(j) == ' '){
					chars[runningIndex] = '%';
					chars[runningIndex+1] = '2';
					chars[runningIndex+2] = '0';
					runningIndex = runningIndex+3;
				}
				else{
					chars[runningIndex] = str.charAt(j);
					runningIndex++;
				}
			}
			return String.valueOf(chars);
		}
		return str;
	}
	public static void main(String[] args) {
		/*System.out.println("Does the string ABCD has unique characters: "+isStringWithUniqueChars("ABCD"));
		System.out.println("Does the string Praveen has unique characters: "+isStringWithUniqueChars("Praveen"));
		System.out.println("Does the string 12345 has unique characters: "+isStringWithUniqueChars("12345"));
		System.out.println("Does the string Kumar has unique characters: "+isStringWithUniqueChars("Kumar"));
		System.out.println("Does the string ABCDeeeeeeeeeeeeeee has unique characters: "+isStringWithUniqueChars("ABCDeeeeeeeeeeeeeee"));
		//*********************************************
		System.out.println("Reverse of string ABCD: "+reverseString("ABCD"));
		System.out.println("Reverse of string ABCDE: "+reverseString("ABCDE"));
		//*********************************************
		System.out.println("String after removing the duplicates ABCD: "+removeDuplicateChars("ABCD"));
		System.out.println("String after removing the duplicates ABCDEDDFG: "+removeDuplicateChars("ABCDEDDFG"));
		System.out.println("String after removing the duplicates ABCDEFGH: "+removeDuplicateChars("ABCDEFGH"));
		System.out.println("String after removing the duplicates ABCDBCA: "+removeDuplicateChars("ABCDBCA"));
		//*********************************************
*/		System.out.println("Are these strings anagrams: ABCDE, BCAED "+isAnagrams("ABCDE", "BCAED"));
        System.out.println("Are these strings anagrams: ABCDE, BCAEC "+isAnagrams("ABCDE", "BCAEC"));
        System.out.println("Are these strings anagrams: ABCDE, abcde "+isAnagrams("ABCDE", "abcde"));
        //*********************************************
        System.out.println("AB C D E, after replacing spaces with percentage 20 is: "+removeSpacesWithPercent20("AB C D E"));

	}

}
