/**
 * 
 */
package edu.buffalo.dataStructures;

import java.util.Arrays;

import edu.buffalo.util.Util;

/**
 * @author Praveen Kumar Bellam
 * @EmailAddress pbellam@buffalo.edu
 */
public class Stack {
	private Integer[] myStack = new Integer[50];
	private int topStack=-1;
	
	/**
	 * @param args
	 */
	public void fillTheStack(){
		Integer[] tempArray = Util.generateRandomArray();
		topStack = tempArray.length-1;
		for(int i=0;i<myStack.length;i++){
			if(i>topStack){
				myStack[i] = -1;
			}
			else{
				myStack[i] = tempArray[i];
			}
		}
		System.out.println("Initial stack is......");
		Util.printIntArray(myStack);
		
	}
	public void initializeTheStack(){
		Arrays.fill(myStack, -1);
		
	}
	public void push(int value){
		topStack++;
		myStack[topStack] = value;
		//System.out.println("Push: updated stack is......");
		//Util.printIntArray(myStack);
	}
	public int pop(){
		int topElement = myStack[topStack];
		myStack[topStack] = -1;
		topStack--;
		//System.out.println("Pop: updated stack is......");
		//Util.printIntArray(myStack);
		return topElement;
	}
	public int peek(){
		int topElement = myStack[topStack];
		//System.out.println("Peek: Top value of the stack is: "+topElement);
		return topElement;
	}
	public void printStack(){
		Util.printIntArray(myStack);
	}
	public boolean isEmpty(){
		return topStack == -1;
	}
	public int size(){
		if(isEmpty()){
			return 0;
		}
		int count=0;
		for(int i=0;i<50;i++){
			if(myStack[i] != -1){
				count++;
			}
			else{
				break;
			}
		}
		return count;
	}
	public Stack sortStack(Stack input){
		Stack output = new Stack();
		output.initializeTheStack();
		while(!input.isEmpty()){
			int temp = input.pop();
			while(!output.isEmpty() && output.peek() > temp){
				input.push(output.pop());
			}
			output.push(temp);
		}
		return output;
	}
	public static void main(String[] args) {
		Stack stack = new Stack();
		//stack.fillTheStack();
		stack.initializeTheStack();
		stack.push(1000);
		stack.push(975);
		stack.push(980);
		stack.push(991);
		stack.push(993);
		stack.push(992);
		stack.push(985);
		stack.push(970);
		stack.pop();
		stack.pop();
		stack.peek();
		stack.printStack();
		Stack sortedStack = stack.sortStack(stack);
		System.out.println("Sorted stack is: ");
		sortedStack.printStack();
	}

}

