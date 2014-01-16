/**
 * 
 */
package edu.buffalo.dataStructures;

import edu.buffalo.dataStructures.CustomLinkedList.CustomListIterator;
import edu.buffalo.dataStructures.CustomLinkedList.Node;

/**
 * @author Praveen Kumar Bellam
 * @EmailAddress pbellam@buffalo.edu
 */
public class SingleLinkedList<T> {
	Node head;
	public SingleLinkedList(T val){
		head = new Node(val);
	}
	public Node getHead(){
		return head;
	}
	public void setHead(Node node){
		head = node;
	}
	public Node getTail(){
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		return temp;
	}
	public Node add(T val){
		Node newNode = new Node(val);
		Node currTail = getTail(); 
		currTail.next = newNode;
		return newNode;
	}
	public Node getNext(Node node){
		return node.next;
	}
	public void insertAfter(Node node, T val){
		Node newNode = new Node(val);
		Node existingNext = node.next;
		node.next = newNode;
		newNode.next = existingNext;
		
	}
	public CustomListIterator getListIterator(){
		return new CustomListIterator(head);
	}
	public void remove(Node node){
		Node existingNext = node.next;
		node.val = existingNext.val;
		node.next = existingNext.next;
		existingNext.next = null;
	}
	public int getSize(){
		int count = 1;
		Node current=head;
		while(current.next != null){
			current = current.next;
			count++;
		}
		return count;
	}

 public class Node{
	 T val;
	 Node next;
	 Node(T val){
		 this.val = val;
	 }
	 public void setNext(Node next){
		 this.next = next;
	 }
	 public String toString(){
		 return "Value in the node is: "+val;
	 }
	 public Node getNext(){
		 return next;
	 }
	 public T getVal(){
		 return val;
	 }
	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getOuterType().hashCode();
		result = prime * result + ((val == null) ? 0 : val.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (!getOuterType().equals(other.getOuterType()))
			return false;
		if (val == null) {
			if (other.val != null)
				return false;
		} else if (!val.equals(other.val))
			return false;
		return true;
	}
	private SingleLinkedList getOuterType() {
		return SingleLinkedList.this;
	}
 }
 
 public class CustomListIterator{
	 Node current;
	 public CustomListIterator(Node node){
		 current = node;
	 }
	 public boolean hasNext(){
		 return (current != null);
	 }
	 public Node next(){
		 Node temp=current;
		 current = current.next;
		 return temp;
	 }
	 
 }
}
