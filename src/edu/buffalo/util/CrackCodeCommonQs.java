/**
 * 
 */
package edu.buffalo.util;

import java.util.Stack;

/**
 * @author Praveen Kumar Bellam
 * @EmailAddress pbellam@buffalo.edu
 */
public class CrackCodeCommonQs {
	public static String[] permutateString(String str){
		/*if(str == null || str.length() == 0){
			return null;
		}*/
		System.out.println("Input to permutateString is: "+str);
		if(str.length() == 1){
			return new String[]{str};
		}
		String[] permutations = new String[(int) Util.findFactorial(str.length())];
		char firstLetter = str.charAt(0);
		String[] subStringPerms = permutateString(str.substring(1));
		int currIndexPermutations = 0;
		for(String currWord:subStringPerms){
			System.out.println("Curr word is: "+currWord);
			for(int i=0;i<currWord.length();i++){
				permutations[currIndexPermutations] = i==0?firstLetter+currWord:currWord.substring(0, i)+firstLetter+currWord.substring(i, currWord.length());
				currIndexPermutations++;
			}
			permutations[currIndexPermutations] = currWord+firstLetter;
			currIndexPermutations++;
		}
		return permutations;		
	}
	
	public static void swapNumbers(int a, int b){
		System.out.println("Initial values: a = "+a+" b = "+b);
		a = b-a;
		b = b-a;
		a = a+b;
		System.out.println("Final values: a = "+a+" b = "+b);
	}
	
	public static int getMax(int a, int b){
		int c = a-b;
		int k = (c>>31) & 0x1;
		int max = a-k*c;
		return max;
	}
	
	public static void printArray(Object[] array){
		System.out.println("Values in the array are: ");
		for(int i=0;i<array.length;i++){
			System.out.print(String.valueOf(array[i])+" ");
		}
		System.out.println();
	}
	
	public static int findTrailingZerosInFactorial(int n){
		int count = 0;
		for(int i=5;n/i>0;i=i*5){
			count = count + n/i;
		}
		return count;
	}

	public static void printPar(int l, int r, char[] str, int count) {
		System.out.println("printPar is called with: l - "+l+" r - "+r+" count - "+count+" str - "+String.valueOf(str));
		if (l < 0 || r < l)
			return; // invalid state
		if (l == 0 && r == 0) {
			System.out.println(str); // found one, so print it
		} else {
			if (l > 0) { // try a left paren, if there are some available
				str[count] = '(';
				printPar(l - 1, r, str, count + 1);
			}
			if (r > l) { // try a right paren, if there’s a matching left
				System.out.println("Count value inside right parentesis is: "+count);
				str[count] = ')';
				printPar(l, r - 1, str, count + 1);
			}
		}
	}

	public static void printPar(int count) {
		char[] str = new char[count * 2];
		printPar(count, count, str, 0);
	}
	
	public static int makeChange(int n, int denom){
		int nextDenom = 0;
		switch(denom){
		case 25:
			nextDenom = 10;
			break;
		case 10:
			nextDenom = 5;
			break;
		case 5:
			nextDenom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for(int i = 0; i * denom <= n; i++){
			ways += makeChange(n - i * denom, nextDenom);
			}
		return ways;		
	}
	
	public static int binarySearch(Integer[] array, int low, int high, int search){
		if(low>high){
			return -1;
		}
		int middle = (low+high)/2;
		if(search == array[middle]){
			return middle;
		}
		if(search>array[middle]){
			return binarySearch(array, middle+1, high, search);
		}
		else{
			return binarySearch(array, low, middle-1, search);
		}
	}
	
	public static int findElementInRotatedArray(Integer[] array, int l, int r, int search){
		if(l>r){
			return -1;
		}
		if(l == r){
			return array[l] == search?l:-1;
		}
		int index = -1;		
		int m = (l+r)/2;
		if(array[m] == search){
			return m;
		}
		if(array[m]<array[r]){//Then m to r is a sorted array
			if(search>=array[m] && search<=array[r]){
				return binarySearch(array, m, r, search);
			}
		}
		else{
			int result = findElementInRotatedArray(array, m, r, search);
			if(result != -1){
				return result;
			}
		}
		if(array[l]<array[m]){//Then m to r is a sorted array
			if(search>=array[l] && search<=array[m]){
				return binarySearch(array, l, m, search);
			}
		}
		else{
			int result = findElementInRotatedArray(array, l, m, search);
			if(result != -1){
				return result;
			}			
		}
		
		return index;
	}
	
	public static void findMaxSubSequence(Integer[] array){
		int globalMax = array[0], u = 0, v = 0;
		int currentMax = array[0], i = 0;
		for(int j=1; j<=array.length-1;j++){
			if(currentMax<0){
				currentMax=array[j];
				i=j;
			}
			else{
				currentMax+=array[j];
			}
			System.out.println("CurrentMax value is: "+currentMax);
			if(currentMax>globalMax){
				globalMax=currentMax;
				u=i;
				v=j;
			}
		}
		System.out.println("Maximum subsequence contains following elements: ");
		for(int k=u;k<=v;k++){
			System.out.print(array[k]);
		}
		System.out.println();
	}
	
	public static void printInEnglish(int input){
		String[] zukTo9 = {"","one","two","three","four","five","six","seven","eight","nine"};
		//String[] elevenTo19 = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		String[] tenTo90 = {"ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
		String[] hundTo900 = {"one hundred","two hundred","three hundred","four hundred","five hundred","six hundred","seven hundred","eight hundred","nine hundred"};
		String str = "";
		int num = input;
		int position = 1;
		while(num>0){
			int reminder = num%10;
			num = num/10;
			String currStr = " ";
			if(position == 1){
				currStr = currStr + zukTo9[reminder];
			}
			else if(position == 2){
				currStr = currStr + tenTo90[reminder-1];
			}
			else if(position == 3){
				currStr = currStr + hundTo900[reminder-1];
			}
			position++;
			//System.out.println("Reminder is: "+reminder+" currStr is: "+currStr);
			str=currStr+str;				
		}
		System.out.println("Number: "+input+" - "+str);		
	}
	
	public static void decimalToBinary(int input){
		int num = input;
		String str = "";
		while(num>0){
			int reminder = num%2;
			num = num/2;
			str = reminder+str;
		}
		System.out.println("Decimal: "+input+" Binary: "+str);
	}
	
	public static boolean isParenthisisBalanced(String str){
		boolean result = true;
		char[] chars = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		for(char c:chars){
			if( c == '[' || c == '{' || c == '('){
				stack.push(c);
				//System.out.println("Pushed "+c+" onto the stack");
			}
			else if(stack.isEmpty()){
				//System.out.println("Exiting because stack is empty");
				return false;
			}
			else{
				if(c == '}' && stack.pop() != '{') return false;
				if(c == ')' && stack.pop() != '(') return false;
				if(c == ']' && stack.pop() != '[') return false;
				//System.out.println("Current character is: "+c+" top of the stack is: "+stack.peek()+" and are they equal? "+(c != stack.peek()));
			}
		}
		if(!stack.isEmpty()){
			return false;
		}
		return result;
	}
	
	public static int getNumberOfRotations(Integer[] array){
		//just find the index of minimum element
		int index = -1;
		int low = 0;
		int high = array.length-1;
		while(low<=high){
			if(array[low]<=array[high]){
				return low;
			}
			//*************************
			int length = high-low+1;
			int middle = (low+high)/2;
			int left = (middle+length-1)%length;
			int right = (middle+length+1)%length;
			if(array[middle] < array[left] && array[middle] < array[right]){
				return middle;
			}
			//*************************
			if(array[middle]<=array[high]){
				high = middle-1;
				continue;
			}
			else{
				low = middle+1;
			}
		}		
		return index;
	}
	
	public static void main(String[] args) {
		/*printArray(permutateString("abc"));
		swapNumbers(3,4);
		System.out.println("Maximum of 7, 9 is: "+getMax(7, 9));
		System.out.println("Maximum of 5, 5 is: "+getMax(5, 5));
		System.out.println("Factorial of 15 is: "+Util.findFactorial(15));
		System.out.println("Number of trailing zeros in 15 factorial is: "+findTrailingZerosInFactorial(15));
		printPar(2);
		Integer[] rotatedArray = {7,8,9,1,2,3,4,5,6};
		System.out.println("Index of element 9 in the rotated sorted array: "+findElementInRotatedArray(rotatedArray, 0, 8, 9));
		Integer[] maxSumSeqArray = {100,9,6,-100,-3,4,-2,3,2,-9,2,22};
		findMaxSubSequence(maxSumSeqArray);
		printInEnglish(143);
		printInEnglish(999);
		decimalToBinary(6);
		decimalToBinary(7);
		decimalToBinary(8);
		decimalToBinary(15);
		decimalToBinary(26);
		System.out.println("Is {([])} balanced: "+isParenthisisBalanced("{([])}"));
		System.out.println("Is {([)} balanced: "+isParenthisisBalanced("{([)}"));
		System.out.println("Is {([)]} balanced: "+isParenthisisBalanced("{([)]}"));
		System.out.println("Is [] balanced: "+isParenthisisBalanced("[]"));*/
		Integer[] rotatedArray2 = {7,8,9,1,2,3,4,5,6};
		Integer[] rotatedArray3 = {7,8,1,2,2,2,2,2,2};
		Integer[] rotatedArray4 = {2,3,2,2,2,2,2,2,2};
		System.out.println("The no. of times that the array - rotatedArray2 has been rotated is: "+getNumberOfRotations(rotatedArray2));
		System.out.println("The no. of times that the array - rotatedArray3 has been rotated is: "+getNumberOfRotations(rotatedArray3));
		System.out.println("The no. of times that the array - rotatedArray4 has been rotated is: "+getNumberOfRotations(rotatedArray4));
	}
}
