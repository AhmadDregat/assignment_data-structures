import java.util.Arrays;

import java.util.Scanner;

/*
 *Author: ahmad dregat 
 */
public class TernaryHeap {

	int heap [];
	int size ;
	/** Constructor */
	public TernaryHeap(int capacity) {

		this.size=size;
		heap=new int [capacity];
	}
	/** rightChild returns the right child of vertex  i*/
	private int right(int i) {
		return 3*i+3;
	}
	/** leftChild returns the left child of vertex  i*/
	public static int left(int i) {
		return 3*i+1;
	}
	/** midChild returns the mid child of vertex  i*/
	private int mid(int i) {
		return 3*i+2;
	}
	/** parent returns the parent of vertex  i*/
	private int parent(int i) {
		return((3*i)-1)/3;
	}


	/** returns true if the heap is empty, otherwise false */
	private boolean isEmpty() {
		return size==0;
	}

	/** 	
	 * The maxHeapfy maintains the Max-Heap Property
	 * complexity is O(log(n))
	 * @param heap - array of numbers
	 * @param i - vertex 
	 * @param Size - size of the heap
	 * The function of maxHeapfy is to let the value of heap[i] "float-down"
	 * in the Max-Heap so that subtree rooted at index i becomes a Max-Heap
	 */
	public void maxHeapify(int i,int size ) {
		int larg ;
		int left =left(i);
		int right =right(i);
		if (left <size&&heap[left]>heap[i]) {
			larg=left;
		}
		else {
			larg =i;
		}
		if (right<size && heap[right]>heap[larg]){
			larg = right;
		}
		if (larg!=i){
			swap(i, larg);
			maxHeapify(larg, size);
		}		
	}
	public void heapUp (int startNode) { 
		int currNode = startNode; 
		while (currNode != 0) { 
			if (heap[currNode] > heap[parent(currNode)]) { 
				int temp = heap[currNode]; 
				heap[currNode] = heap[parent(currNode)]; 
				heap[parent(currNode)] = temp;

				currNode = parent(currNode); 
			} else { 
				break; 
			} 
		} 
	}

	/** 
	 * Inserts an element into the heap. 
	 */ 
	public boolean insert(int k) {
		if(isfull()) return false;
		heap[size] = k; 
		size++; 
		heapUp (size - 1); 
		return true;
	}


	private void swap(int i, int larg) {
		// TODO Auto-generated method stub
		int temp =heap[i];
		heap[i]=heap[larg];
		heap[larg]=temp ;

	}
	private boolean isfull() {
		return size==heap.length;
	}
	
	

	public int remove_max() {
		int max=Integer.MIN_VALUE; // infinity
		if (!isEmpty()){
			max = heap[0];
			heap[0]=heap[size-1];
			size = size-1;
			maxHeapify(0, size);
		}
		return max;
	}
	public void print(){
		for (int i=0; i<size; i++){
			System.out.print(heap[i]+", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n =sc.nextInt();
		int [] arr=new int [n];
		//int capacity=Integer.MAX_VALUE;
		TernaryHeap h = new TernaryHeap(arr.length);
		h.buildMaxHeap();
		//h.print();
		h.insert(9);
		h.insert(8);
		h.insert(6);
		h.insert(7);
		h.insert(5);
		h.insert(83);
		h.insert(127);
		h.insert(4);
		h.print();
	///	System.out.println(Arrays.toString(arr));
	}



}