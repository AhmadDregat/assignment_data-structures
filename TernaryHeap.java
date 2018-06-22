import java.util.Arrays;
import java.util.Locale.LanguageRange;
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
		heap=new int [capacity+1];
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
	/** 
	 * buildMaxHeap produces a Max-Heap from an unordered input array.
	 * buildMaxHeap runs in linear time O(n)
	 */
	public void buildMaxHeap(){
		for (int i=size/2; i>=0; i--){
			maxHeapify(i, size);
		}
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
	/**
	 * heapIncreaseKey(i, key) increases the value of element i-s key 
	 * to the new value key, which is assumed to be at least as large
	 * as i's current key value
	 */
	private void heapIncreaseKey(int i, int key){
		if (key >=heap[i]){
			heap[i] = key;
			while (i>0 && heap[parent(i)]<heap[i]){
				swap(i, parent(i));
				i = parent(i);
			}
		}
	}
	/**
	 * heapInsert(k) inserts the element key into a heap
	 */
	public boolean insert(int k){
		boolean flag =true ;
	//	if (isfull()) {
			//System.out.println("Heap is full!");
		//	return flag=false;
		//}else {
			int temp[] = new int[size+1];
			for (int i=0; i<size; i++){
				temp[i]=heap[i];
			} 
			heap = temp;
			size = size+1;
		heap[size-1] = Integer.MIN_VALUE;
		heapIncreaseKey(size-1, k);
		return flag ;
		//}
	}
	
	/*	public boolean insert(int k) {
		boolean flag=true;
	 	if (isfull()) {
			System.out.println("Heap is full!");
			return flag=false;
		}

		heap[size++] = k;
		maxHeapify(heap[size],size);

		return flag;
	}

	 */
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
		h.insert(7);
		h.insert(3);
		h.insert(1);
		h.insert(6);
		h.insert(9);

		h.insert(8);
		h.insert(12);
		
		h.remove_max();
		h.insert(50);
		h.print();
		h.remove_max();
		h.print();
	///	System.out.println(Arrays.toString(arr));
	}



}