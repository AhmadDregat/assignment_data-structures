import java.util.Scanner;

public class TernaryHeap {

	private int heap[]; 
	private int size; 
	private int d;
    
	/** 
	 * Creates a new heap. 
	 * 
	 * @param size maximum size of the heap. 
	 * @param d    the maximum number of children 
	 *             of each node. 
	 */ 
	public TernaryHeap ( int capacity) { 
		heap = new int[capacity]; 
		this.size = 0; 
		this.d = 3; 
	
	}
	
	 	/** rightChild returns the right child of vertex  i
	 complexity is O(1)
	 */
	private int right(int i) {    
		return d * i + 3;
	}
	/** leftChild returns the left child of vertex  i
	 *  complexity is O(1)
	 *  */
	private int left(int i) {  
		return d * i + 1;
	}
	/** midChild returns the mid child of vertex  i
	 * complexity is O(1) */
	private int mid(int i) {  
		return d * i + 2;
	}
	/** parent returns the parent of vertex  i
	 * complexity is O(1)*/
	private int parent(int i) {
		return (i - 1)/d;
	}



	/** returns true if the heap is empty, otherwise false */
	private boolean isEmpty() {
		return size==0;
	}


	/** 	
	 * The Heapfydown maintains the Max-Heap Property
	 * complexity is O(log(n))
	 * @param heap - array of numbers
	 * @param i - vertex 
	 * @param Size - size of the heap
	 * The function of Heapfydown is to let the value of heap[i] "float-down"
	 * in the Max-Heap so that subtree rooted at index i becomes a Max-Heap
	 */
	public void Heapifydown (int i,int size ) {
		int larg=i ;
		int left =left(i);
		int right =right(i);
		int mid =mid(i);
		larg =i;
		if (left <size&&heap[left]>heap[i]) {
			larg=left;
		}

		if (right<size && heap[right]>heap[larg]){
			larg = right;
		}
		if (mid<size && heap[mid]>heap[larg]){
			larg = mid;
		}

		if (larg!=i){
			swap(i, larg);

		Heapifydown(larg, size);
		}

	 }
	/**
	 *  remove_max removes and returns the largest element of heap
	 * complexity O(log(n))
	*/

	public int remove_max() {
		int max=Integer.MIN_VALUE; // infinity
		if (!isEmpty()){
			max = heap[0];
			heap[0]=heap[size-1];
			size --;
			Heapifydown(0,size-1);
		}
		return max;
	}
	/**
	 * swaping two elements 
	 * complexity O(1)
	 */
	private void swap(int i, int larg) {
		// TODO Auto-generated method stub
		int temp =heap[i];
		heap[i]=heap[larg];
		heap[larg]=temp ;

	}
	/**
	 * * complexity is O(log(n))
	 */

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
	 * isfuul return if the heap is full or not 
	 * complexity O(1)
	 */
	private boolean isfull() {
		return size==heap.length;
	}
	/** 
	 * Inserts an element into the heap. 
	 * Complexity is O(h) where h is the height of the heap. 
	 * O(h)=O(log(n))
	 */ 
	public boolean insert (int value) {
		if(isfull())return false;
		heap[size] = value; 
		size++; 
		heapUp (size - 1); 
	return true ;
	}

	public void print(){
		System.out.print ("["); 
		for (int i = 0; i < size; i++) { 
			System.out.print (heap[i] + ", "); 
		} 
		System.out.println ("]"); 
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n =sc.nextInt();
		int [] arr=new int [n];
		//int capacity=Integer.MAX_VALUE;
		TernaryHeap h = new TernaryHeap(arr.length);
	
		//h.print();
			//insert(10);
		///insert(1);
	//h.insert(7);
			h.insert(9);
		h.insert(8);
		h.insert(6);
	    h.insert(7);
		h.insert(5);
		h.insert(3);
		h.insert(7);
		h.insert(4);
		//h.insert(25);
       // h.remove_max();
		h.print();

		//	System.out.println(mid(0));
	}


}