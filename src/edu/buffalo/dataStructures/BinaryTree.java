/**
 * 
 */
package edu.buffalo.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Praveen Kumar Bellam
 * @EmailAddress pbellam@buffalo.edu
 */
public class BinaryTree {
	Node root;
	BinaryTree(int key, String name){
		root = new Node(key, name);
	}
	public void addElement(int key, String name){
		Node newNode = new Node(key, name);
		Node nodeToAdd = root;
		while(true){
			if(key < nodeToAdd.key){
				if(nodeToAdd.leftChild != null){
					nodeToAdd = nodeToAdd.leftChild;
					continue;
				}
				else{
					nodeToAdd.leftChild = newNode;
					newNode.parent = nodeToAdd;
					return;
				}
			}
			else{
				if(nodeToAdd.rightChild != null){
					nodeToAdd = nodeToAdd.rightChild;
					continue;
				}
				else{
					nodeToAdd.rightChild = newNode;
					newNode.parent = nodeToAdd;
					return;
				}				
			}
		}
	}
	public void rearrangeTree(Node newNode, Node existingNode){
		//This is a case, when we are trying to add an element, whose value is less than root key but greater than root's left child value
		if(newNode.key>existingNode.key){
			newNode.rightChild = existingNode.rightChild;
			newNode.parent = existingNode.parent;
			existingNode.parent = newNode;
			existingNode.rightChild = null;
			newNode.leftChild = existingNode;
		}
		else{
			newNode.leftChild = existingNode.leftChild;
			existingNode.leftChild = null;
			newNode.rightChild = existingNode;			
		}
		
	}
	public void printTree(){//Breadth First Search
		System.out.println("Printing using breadth first search algorithm");
		java.util.Queue<Node> nodeQ = new LinkedList<>();
		nodeQ.add(root);
		while(!nodeQ.isEmpty()){
			Node currNode = nodeQ.poll();
			System.out.println(currNode+" and it is at level: "+(getHeight(root)-getHeight(currNode)));
			if(currNode.leftChild != null){
				nodeQ.add(currNode.leftChild);
			}
			if(currNode.rightChild != null){
				nodeQ.add(currNode.rightChild);				
			}
		}		
	}
	
	public void printDFSTree(){//Depth first search
		System.out.println("Printing using depth first search algorithm");
		java.util.Stack<Node> nodeQ = new Stack<>();
		nodeQ.add(root);
		while(!nodeQ.isEmpty()){
			Node currNode = nodeQ.pop();
			System.out.println(currNode+" and it is at level: "+(getHeight(root)-getHeight(currNode)));
			if(currNode.rightChild != null){
				nodeQ.add(currNode.rightChild);				
			}
			if(currNode.leftChild != null){
				nodeQ.add(currNode.leftChild);
			}
		}
	}
	
	public int getHeight(Node rootNode){
		if(rootNode == null){
			return 0;
		}
		return 1+Math.max(getHeight(rootNode.leftChild),getHeight(rootNode.rightChild));
	}
	public int getMaxDepth(Node rootNode){
		if(rootNode == null){
			return 0;
		}
		return 1+Math.max(getMaxDepth(rootNode.leftChild), getMaxDepth(rootNode.rightChild));
	}
	public int getMinDepth(Node rootNode){
		if(rootNode == null){
			return 0;
		}
		return 1+Math.min(getMaxDepth(rootNode.leftChild), getMaxDepth(rootNode.rightChild));
	}
	public static BinaryTree createTreeFromSortedArray(int[] array, int start, int end){
		if(end<start){
			BinaryTree nullTree = new BinaryTree(-1, "Null Value");
			nullTree.root = null;
			return nullTree;
		}
		int mid = (start+end)/2;
		BinaryTree bTree = new BinaryTree(array[mid], "Value "+array[mid]);
		bTree.root.leftChild = createTreeFromSortedArray(array, start, mid-1).root;
		bTree.root.rightChild = createTreeFromSortedArray(array, mid+1, end).root;
		return bTree;
	}
	
	public Node getRoot(){
		return root;
	}
	
	public int getSize(Node node){
		if(node == null){
			return 0;
		}
		return 1+getSize(node.leftChild)+getSize(node.rightChild);
	}
	
	public int getSizeUsingIteration(Node node){
		int count = 0;
		Stack<Node> stack = new Stack();
		stack.push(node);
		while(!stack.isEmpty()){
			Node temp = stack.pop();
			count++;
			if(temp.leftChild != null){
				stack.push(temp.leftChild);
			}
			if(temp.rightChild != null){
				stack.push(temp.rightChild);
			}
		}
		return count;
	}	
	
	/**
	 * @param node
	 * PreOrder traversal using iteration - visit the parent first and then left and right children
	 */
	public void printDFSPreOrderTraversalUsingIteration(Node node){
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()){
			Node curr = stack.pop();
			System.out.println(curr);
			if(curr.rightChild != null){
				stack.push(curr.rightChild);
			}
			if(curr.leftChild != null){
				stack.push(curr.leftChild);
			}
		}
	}	
	
	/**
	 * @param node
	 * PreOrder traversal - visit the parent first and then left and right children
	 */
	public void printDFSPreOrderTraversal(Node node){
		if(node == null){
			return;
		}
		System.out.println(node);
		printDFSPreOrderTraversal(node.leftChild);
		printDFSPreOrderTraversal(node.rightChild);
	}	
	
	/**
	 * @param node
	 * InOrder traversal - visit the left child, then the parent and the right child
	 */
	public void printDFSInOrderTraversalUsingIteration(Node node){
		Stack<Node> stack = new Stack<>();
		while(node != null){
			stack.push(node);
			Node tempLeft = node.leftChild;
			boolean nodeUpdated = false;
			while(tempLeft != null){
				stack.push(tempLeft);
				tempLeft = tempLeft.leftChild;
			}
			while(!stack.isEmpty()){
				Node curr = stack.pop();
				System.out.println(curr);
				if(curr.rightChild == null){
					continue;
				}
				else{
					node = curr.rightChild;
					nodeUpdated = true;
					break;
				}
			}
			if(!nodeUpdated){
				stack = null;
				break;
			}
		}
	}	
	
	/**
	 * @param node
	 * InOrder traversal - visit the left child, then the parent and the right child
	 */
	public void printDFSInOrderTraversal(Node node){
		if(node == null){
			return;
		}
		printDFSInOrderTraversal(node.leftChild);
		System.out.println(node);
		printDFSInOrderTraversal(node.rightChild);
	}	
	
	/**
	 * @param node
	 * PostOrder traversal - visit left child, then the right child and then the parent
	 */
	public void printDFSPostOrderTraversalUsingIteration(Node node){
		Stack<Node> stack = new Stack<>();
		ArrayList<Node> visitedList = new ArrayList<>();
		while(node != null){
			stack.push(node);
			Node tempLeft = node.leftChild;
			boolean nodeUpdated = false;
			while(tempLeft != null){
				stack.push(tempLeft);
				tempLeft = tempLeft.leftChild;
			}
			while(!stack.isEmpty()){
				Node curr = stack.peek();
				if(visitedList.contains(curr)){
					System.out.println(curr);
					stack.pop();
					visitedList.remove(curr);
					continue;
				}
				if(curr.rightChild == null){
					System.out.println(curr);
					stack.pop();
					continue;
				}
				else{
					visitedList.add(curr);
					node = curr.rightChild;
					nodeUpdated = true;
					break;
				}
			}
			if(!nodeUpdated){
				stack = null;
				visitedList = null;
				break;
			}
		}
	}	
	
	/**
	 * @param node
	 * PostOrder traversal - visit left child, then the right child and then the parent
	 */
	public void printDFSPostOrderTraversalUsingTwoStacks(Node node){
		Stack<Node> stack = new Stack<>();
		Stack<Node> out = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()){
			Node curr = stack.pop();
			out.push(curr);
			if(curr.leftChild != null){
				stack.push(curr.leftChild);
			}
			if(curr.rightChild != null){
				stack.push(curr.rightChild);
			}			
		}
		while(!out.isEmpty()){
			System.out.println(out.pop());
		}
	}	
	
	/**
	 * @param node
	 * PostOrder traversal - visit left child, then the right child and then the parent
	 */
	public void printDFSPostOrderTraversal(Node node){
		if(node == null){
			return;
		}
		printDFSPostOrderTraversal(node.leftChild);
		printDFSPostOrderTraversal(node.rightChild);
		System.out.println(node);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(10,"root");
		binaryTree.addElement(5, "firstLevel");
		binaryTree.addElement(15, "firstLevel");
		binaryTree.addElement(2, "secondLevel");
		binaryTree.addElement(8, "secondLevel");
		binaryTree.addElement(12, "secondLevel");
		binaryTree.addElement(18, "secondLevel");
		binaryTree.addElement(1, "3rdLevel");
		binaryTree.addElement(3, "3rdLevel");
		binaryTree.addElement(7, "3rdLevel");
		binaryTree.addElement(9, "3rdLevel");
		binaryTree.addElement(11, "3rdLevel");
		binaryTree.addElement(13, "3rdLevel");
		binaryTree.addElement(17, "3rdLevel");
		binaryTree.addElement(19, "3rdLevel");
		System.out.println("Printing the tree in depth first search - post order traversal");
		binaryTree.printDFSPostOrderTraversal(binaryTree.root);
		System.out.println("Printing the tree in depth first search - post order traversal using iteration");
		binaryTree.printDFSPostOrderTraversalUsingIteration(binaryTree.root);
		System.out.println("Printing the tree in depth first search - post order traversal using two stacks");
		binaryTree.printDFSPostOrderTraversalUsingTwoStacks(binaryTree.root);
		//binaryTree.printDFSTree();
		/*System.out.println("Printing the tree in depth first search - In order traversal");
		binaryTree.printDFSInOrderTraversal(binaryTree.root);
		System.out.println("Printing the tree in depth first search - In order traversal using iteration");
		binaryTree.printDFSInOrderTraversalUsingIteration(binaryTree.root);
		binaryTree.printTree();
		System.out.println("Height of a tree is: "+binaryTree.getHeight(binaryTree.root));
		int[] array = {0,1,2,3,4,5,6,7,8};
		createTreeFromSortedArray(array, 0, 8).printTree();
		System.out.println("Size of the binary tree: "+binaryTree.getSize(binaryTree.root));
		System.out.println("Printing the tree in depth first search - pre order traversal");
		binaryTree.printDFSPreOrderTraversal(binaryTree.root);
		System.out.println("Printing the tree in depth first search - In order traversal");
		binaryTree.printDFSInOrderTraversal(binaryTree.root);*/
		/*System.out.println("Printing the tree in depth first search - Pre order traversal");
		binaryTree.printDFSPreOrderTraversal(binaryTree.root);
		System.out.println("Printing the tree in depth first search - Pre order traversal using iteration");
		binaryTree.printDFSPreOrderTraversalUsingIteration(binaryTree.root);
		System.out.println("Size of the binary tree using iteration: "+binaryTree.getSizeUsingIteration(binaryTree.root));*/
		
	}
	public class Node{
		int key;
		String name;
		Node leftChild;
		Node rightChild;
		Node parent;
		
		Node(int key, String name){
			this.key = key;
			this.name = name;			
		}
		public String toString(){
			return "name: "+name+" key: "+key;
		}
		@Override
		public boolean equals(Object o){
			return this.toString().equals(((Node)o).toString());
		}
		
	}

}
