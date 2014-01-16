package edu.buffalo.util;

import java.util.ArrayList;
import java.util.Stack;

import edu.buffalo.dataStructures.CustomLinkedList;
import edu.buffalo.dataStructures.CustomLinkedList.CustomListIterator;
import edu.buffalo.dataStructures.CustomLinkedList.Node;
import edu.buffalo.dataStructures.SingleLinkedList;

/**
 * @author Praveen Kumar Bellam
 * @EmailAddress pbellam@buffalo.edu
 */
public class CrackCodeLinkedListQs {
	static SingleLinkedList.Node head;
	public static <T> void printList(CustomLinkedList<T> list){
		CustomListIterator iterator = list.getListIterator();
		while(iterator.hasNext()){
			System.out.println("current element is: "+iterator.next());
		}		
	}
	
	public static <T> void printSingleLinkedList(SingleLinkedList<T> list){
		edu.buffalo.dataStructures.SingleLinkedList.CustomListIterator iterator = list.getListIterator();
		while(iterator.hasNext()){
			System.out.println("current element is: "+iterator.next());
		}		
	}
	
	public static <T> void printSingleLinkedList(SingleLinkedList.Node node){
		SingleLinkedList.Node temp = node;
		while(temp != null){
			System.out.println(temp);
			temp = temp.getNext();
		}		
	}
	
	public static <T> void removeDuplicateElements(CustomLinkedList<T> list){
		ArrayList<Node> uniqueNodeList = new ArrayList<>();
		CustomListIterator iterator = list.getListIterator();
		while(iterator.hasNext()){
			Node currNode = iterator.next();
			if(uniqueNodeList.contains(currNode)){
				list.remove(currNode);
			}
			else{
				uniqueNodeList.add(currNode);
			}
		}
		
	}
	
	public static void reverseLinkedList(SingleLinkedList list){
		SingleLinkedList.Node head = list.getHead();
		SingleLinkedList.Node previous = null; 
		SingleLinkedList.Node current = head;
		SingleLinkedList.Node currentNext = current.getNext();
		while(current != null){
			//System.out.println("Entered while loop");
			//System.out.println("previous value is: "+previous);
			//System.out.println("current value is: "+current);
			//System.out.println("currentNext value is: "+currentNext);
			current.setNext(previous);
			//System.out.println("Next value after setting it is: "+current.getNext());
			previous = current;
			current = currentNext;
			if(currentNext != null)
				currentNext = currentNext.getNext();			
		}
		list.setHead(previous);
		//System.out.println("Next node is: "+previous.getNext());
	}
	
	public static void reverseLinkedListRecursion(SingleLinkedList.Node node){
		if(node.getNext() == null){
			head = node;
			return;
		}
		reverseLinkedListRecursion(node.getNext());
		SingleLinkedList.Node temp = node.getNext();
		temp.setNext(node);
		node.setNext(null);
	}
	
	public static void printListForwardRecursion(SingleLinkedList.Node head){
		if(head == null){
			return;
		}
		System.out.println(head);
		printListForwardRecursion(head.getNext());		
	}
	
	public static void printListBacwardRecursion(SingleLinkedList.Node head){
		if(head == null){
			return;
		}
		printListBacwardRecursion(head.getNext());
		System.out.println(head);		
	}
	
	public static Object findNthFromLast(CustomLinkedList list, int n){
		Node firstPointer = list.getHead();
		Node secondPointer = list.getHead();
		//Following piece of code will make the pointerDifference between 1st and 2nd pointers to n-1
		int pointerPosition = 1;
		while(pointerPosition<=n-1){
			secondPointer = secondPointer.getNext();
			pointerPosition++;
		}
		while(secondPointer.getNext() != null){
			secondPointer = secondPointer.getNext();
			firstPointer = firstPointer.getNext();
		}		
		return firstPointer.getVal();
		
	}
	
	public static void reverseLinkedListWtack(SingleLinkedList list){
		Stack<SingleLinkedList.Node> stack = new Stack<>();
		SingleLinkedList.Node temp = list.getHead();
		while(temp != null){
			stack.push(temp);
			temp = temp.getNext();			
		}
		SingleLinkedList.Node tempNode = stack.pop();
		list.setHead(tempNode);
		while(!stack.isEmpty()){
			tempNode.setNext(stack.peek());
			tempNode = stack.pop();
		}
		tempNode.setNext(null);
	}
	
	public static SingleLinkedList addLists(SingleLinkedList list1, SingleLinkedList list2){
		int listOneValue = getListValue(list1);
		//System.out.println("List one value is: "+listOneValue);
		int listTwoValue = getListValue(list2);
		//System.out.println("List two value is: "+listTwoValue);
		Integer sum = listOneValue + listTwoValue;
		System.out.println("Sum value is: "+sum.intValue());
		int numOfDigits = findNumberOfDigits(sum);
		System.out.println("Number of digits are: "+numOfDigits);
		Integer[] nodeValues = new Integer[numOfDigits];int number; // = some int
        int partitionTemp = sum;
        int position = 0;
		while (partitionTemp > 0) {
			nodeValues[position] = partitionTemp % 10;
		    partitionTemp = partitionTemp / 10;
		    position++;
		}
		SingleLinkedList<Integer> result = new SingleLinkedList<Integer>(nodeValues[0]);
		for(int i=1;i<nodeValues.length;i++){
			result.add(nodeValues[i]);
		}
		return result;
	}
	
	public static int findNumberOfDigits(int num){
		int absValue = Math.abs(num);
		int divide = 10;
		int count = 1;
		while(absValue/divide>=1){
			count++;
			divide=divide*10;
		}
		return count;
	}
	
	public static int getListValue(SingleLinkedList list1){
		int nodePosition = 0;
		edu.buffalo.dataStructures.SingleLinkedList.Node listOneHead = list1.getHead();
		int listOneValue = ((int)listOneHead.getVal())*(computePower(10,nodePosition));
		edu.buffalo.dataStructures.SingleLinkedList.Node listOneTemp = listOneHead;
		while(listOneTemp.getNext() != null){
			nodePosition++;
			edu.buffalo.dataStructures.SingleLinkedList.Node nextNode = listOneTemp.getNext();
			listOneValue = listOneValue+((int)nextNode.getVal())*(computePower(10,nodePosition));
			listOneTemp = nextNode;
		}
		return listOneValue;
	}
	
	public static int computePower(int a, int b){
		//System.out.println("Input to compute power is: a - "+a+" b - "+b);
		int count=1;
		int result=a;
		while(count<b){
			result=result*a;
			count++;
		}
		//System.out.println("Result of compute power is: "+result);
		return (b==0?1:result);
	}
	
	public static void main(String[] args) {
		/*CustomLinkedList<String> list = new CustomLinkedList<String>("A");
		list.add("E");
		list.add("C");
		list.add("B");
		list.add("D");
		list.add("C");
		list.add("E");
		list.add("F");
		printList(list);
		System.out.println("Size of the list is: "+list.getSize());
		removeDuplicateElements(list);
		System.out.println("List after removing duplicates");
		printList(list);
		System.out.println("Size of the list is: "+list.getSize());
		System.out.println("1st from last is: "+String.valueOf(findNthFromLast(list,1)));
		System.out.println("2nd from last is: "+String.valueOf(findNthFromLast(list,2)));
		System.out.println("3rd from last is: "+String.valueOf(findNthFromLast(list,3)));
		System.out.println("4th from last is: "+String.valueOf(findNthFromLast(list,4)));
		System.out.println("5th from last is: "+String.valueOf(findNthFromLast(list,5)));
		System.out.println("6th from last is: "+String.valueOf(findNthFromLast(list,6)));*/
		//****************************************************************
		SingleLinkedList<String> singleList = new SingleLinkedList<String>("A");
		singleList.add("B");
		SingleLinkedList<String>.Node middleNode = singleList.add("C");
		singleList.add("D");
		singleList.add("E");
		singleList.add("F");		
		System.out.println("Single Linked List is: ");
		printSingleLinkedList(singleList);
		reverseLinkedListWtack(singleList);
		System.out.println("List after reversing it using stack: ");
		printSingleLinkedList(singleList);
		/*System.out.println("Printing linked list forward using recursion: ");
		printListForwardRecursion(singleList.getHead());
		System.out.println("Printing linked list backward using recursion: ");
		printListBacwardRecursion(singleList.getHead());*/
		/*reverseLinkedListRecursion(singleList.getHead());
		printSingleLinkedList(head);*/
		/*reverseLinkedList(singleList);
		System.out.println("Single Linked List after reversing it is: ");
		printSingleLinkedList(singleList);*/
		/*singleList.remove(middleNode);
		System.out.println("Single Linked List after removing the middle node is: ");
		printSingleLinkedList(singleList);
		System.out.println("Test power function: Two cube is "+computePower(2, 3));
		System.out.println("Number of digits in 12345789 is: "+findNumberOfDigits(12345789));
		//*****************************************************************
		System.out.println("Test summing node values");
		SingleLinkedList<Integer> sumListOne = new SingleLinkedList<Integer>(1);
		sumListOne.add(4);
		sumListOne.add(5);
		SingleLinkedList<Integer> sumListTwo = new SingleLinkedList<Integer>(3);
		sumListTwo.add(6);
		sumListTwo.add(1);
		SingleLinkedList resultList = addLists(sumListOne, sumListTwo);
		System.out.println("Result linked list is: ");
		printSingleLinkedList(resultList);*/
	}
}
