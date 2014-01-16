/**
 * 
 */
package edu.buffalo.dataStructures;

/**
 * @author Praveen Kumar Bellam
 * @EmailAddress pbellam@buffalo.edu
 */
public class QueueWithTwoStacks {
	Stack stack1 = new Stack();
	Stack stack2 = new Stack();
	public void filleTheQueue(){
		stack1.initializeTheStack();
		stack2.initializeTheStack();
	}		
	public void push(int val){
		stack1.push(val);
	}
	public int pop(){
		if(!stack2.isEmpty()){
			return stack2.pop();
		}
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
	public int peek(){
		if(!stack2.isEmpty()){
			return stack2.peek();
		}
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		return stack2.peek();		
	}
	public int size(){
		return stack1.size()+stack2.size();
	}	
	
	public static void main(String[] args) {
		QueueWithTwoStacks queue = new QueueWithTwoStacks();
		queue.filleTheQueue();
		queue.push(5);
		queue.push(2);
		queue.push(1);
		queue.push(7);
		queue.push(4);
		queue.push(8);
		System.out.println("Pop from Queue: "+queue.pop());
		System.out.println("Peek from Queue: "+queue.peek());
		queue.push(15);
		System.out.println("Pop from Queue: "+queue.pop());
		System.out.println("Size of the queue is: "+queue.size());

	}

}
