/**
 * 
 */
package edu.buffalo.dataStructures;

import java.util.Arrays;

/**
 * @author Praveen Kumar Bellam
 * @EmailAddress pbellam@buffalo.edu
 */
public class MinHeapUsingArray {
	private int[] heap;
	private int maxSize;
	private int size;	
	public MinHeapUsingArray(int maxSize){
		heap = new int[maxSize];
		this.maxSize = maxSize;
		size = 0;
		heap[0] = Integer.MIN_VALUE;
	}	
	public int getLeftChild(int pos){
		return 2*pos;
	}	
	public int getRightChild(int pos){
		return 2*pos+1;
	}
	public int getParent(int pos){
		return pos/2;
	}
	public void swap(int pos1, int pos2){
		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}
	public boolean isLeaf(int pos){
		return (pos>size/2 && pos<=size);
	}
	public void printHeap(){
		Arrays.toString(heap);
	}
	public void insert(int val){
		size++;
		heap[size] = val;
		int parPos = getParent(size);
		int currPos = size;
		while(heap[parPos]>heap[currPos]){//percolation-up
			swap(parPos, currPos);
			currPos = parPos;
			parPos = getParent(currPos);
		}
	}
	public int deleteMin(){
		swap(1,size);
		size--;
		int curr = 1;
		int smallestchild;
		while (!isLeaf(curr)) {
		    smallestchild = getLeftChild(curr);
		    if(smallestchild>=size){
		    	break;
		    }
		    if ((smallestchild < size) && (heap[smallestchild] > heap[smallestchild+1]))
			smallestchild = smallestchild + 1;
		    if (heap[curr] <= heap[smallestchild]) break;
		    swap(curr,smallestchild);
		    curr = smallestchild;
		}
		System.out.println(heap[size+1]);
		return heap[size+1];
	}
	public void heapSort(){
		int[] output = new int[size];
		int count = 0;
		while(size!=0){
			output[count] = deleteMin();
			count++;
		}
		Arrays.toString(output);
	}
	
	public static void main(String[] args) {
		MinHeapUsingArray minHeap = new MinHeapUsingArray(50);
		minHeap.insert(8);
		minHeap.insert(3);
		minHeap.insert(7);
		minHeap.insert(1);
		minHeap.insert(5);
		minHeap.insert(9);
		minHeap.insert(2);
		minHeap.heapSort();

	}

}
