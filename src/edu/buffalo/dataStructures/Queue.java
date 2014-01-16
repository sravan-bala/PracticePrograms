/**
 * 
 */
package edu.buffalo.dataStructures;

import java.util.Arrays;
import java.util.LinkedList;

import edu.buffalo.util.Util;

/**
 * @author Praveen Kumar Bellam
 * @EmailAddress pbellam@buffalo.edu
 */
public class Queue {
	private Integer[] myQueue;
	private int topQueue;//Index till which elements are filled
	private int frontIndex = -1;
	
	public Queue(int queueSize){
		myQueue = new Integer[queueSize];
		Arrays.fill(myQueue, -1);
		topQueue = -1;
	}
	
	public void insert(int val){
		if(frontIndex == -1){
			frontIndex++;
		}
		topQueue++;
		//System.out.println("topQueue value in insert is: "+topQueue);
		myQueue[topQueue] = val;
		//System.out.println("INSERT:--------------------");
		//Util.printIntArray(myQueue);
	}
	
	public void priorityInsert(int val){
		if(frontIndex == -1){
			frontIndex++;
		}
		if(topQueue != -1 && val>myQueue[topQueue]){
			int moveTo = frontIndex;
			for(int i=topQueue;i>=frontIndex;i--){
				if(myQueue[i]>val){
					moveTo = i+1;
					break;
				}
			}
			int temp = myQueue[moveTo];
			myQueue[moveTo] = val;
			for(int j=(moveTo+1);j<=(topQueue+1);j++){
				int tempForSwap = myQueue[j];
				myQueue[j] = temp;
				temp = tempForSwap;
			}
			/*int tempSwap = myQueue[topQueue];
			myQueue[topQueue] = val;
			myQueue[topQueue+1] = tempSwap;*/
		}
		else{
			myQueue[topQueue+1] = val;
		}
		topQueue++;
		//System.out.println("PRIORITY INSERT:--------------------");
		//Util.printIntArray(myQueue);
		
	}
	
	public int get(){
		if(frontIndex < 0){
			System.out.println("GET: No elements in the Queue");
			return -1;
		}
		//System.out.println("First element of Q is: "+myQueue[frontIndex]);
		return myQueue[frontIndex];
	}
	
	public int remove(){
		if(frontIndex < 0){
			return -1;
		}
		int frontElement = myQueue[frontIndex];
		//System.out.println("Removing the element of Q: "+myQueue[frontIndex]);
		myQueue[frontIndex] = -1;
		
		if(frontIndex == topQueue){
			frontIndex = -1;
			topQueue = -1;
		}
		if(frontIndex+1 <= topQueue){
			frontIndex++;
		}
		return frontElement;
		//myQueue[0];
	}
	public boolean isEmpty(){
		return (size() == 0);
	}
	public void printQueue(){
		Util.printIntArray(myQueue);
	}
	public Queue sortQueue(Queue input){
		//TO DO - NOT COMPLETE
		//System.out.println("Is input queue empty: "+input.isEmpty());
		//System.out.println("Input queue size is: "+input.size());
		LinkedList<Integer> output = new LinkedList<>();
		Queue outputQueue = new Queue(input.size());
		while(!input.isEmpty()){
			int temp = input.remove();
			System.out.println("Removed "+temp+" from input queue");
			//System.out.println("Size of the input queue is: "+input.size());
			while(!output.isEmpty() && output.peek() > temp){
				int outTemp = output.remove();
				input.insert(outTemp);
				System.out.println("Removed "+outTemp+" from output queue and inserted in input queue");
				//System.out.println("Size of the input queue is: "+input.size());
				//System.out.println("Size of the output queue is: "+output.size());
			}
			output.add(temp);
			//System.out.println("Size of the output queue is: "+output.size());
			System.out.println("Inserted "+temp+" into output queue");
		}		
		return outputQueue;
	}
	public int size(){
		int count=0;
		for(int i=0;i<myQueue.length;i++){
			if(myQueue[i] != -1){
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		/*Queue queue = new Queue(50);
		queue.insert(10);
		queue.insert(20);
		queue.insert(30);
		queue.get();
		queue.remove();
		queue.get();
		System.out.println("Priority Qs");
		Queue priorityQ = new Queue(50);
		priorityQ.priorityInsert(10);
		priorityQ.priorityInsert(20);
		priorityQ.priorityInsert(21);
		priorityQ.priorityInsert(30);
		priorityQ.priorityInsert(15);
		priorityQ.priorityInsert(50);
		priorityQ.priorityInsert(40);
		priorityQ.get();
		priorityQ.remove();
		priorityQ.get();*/

		Queue queue = new Queue(500);
		queue.insert(9);
		queue.insert(6);
		queue.insert(3);
		queue.insert(15);
		queue.insert(10);
		queue.insert(20);
		queue.printQueue();
		System.out.println("Size of the queue is: "+queue.size());
		/*Queue SortedQueue = queue.sortQueue(queue);
		System.out.println("Queue after sorting: ");
		SortedQueue.printQueue();*/
	}

}
