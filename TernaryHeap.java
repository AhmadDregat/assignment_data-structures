/*
 *Author: ahmad dregat 
 */
public class TernaryHeap {
	int d;
	int heap [];
	int size ;
	/** Constructor */
	public TernaryHeap(int capacity) {
		this.d=d;
		this.size=size;
		heap=new int [capacity+1];
	}
	/** rightChild returns the right child of vertex  i*/
	private int right(int i) {
		return 3*i+1;
	}
	/** leftChild returns the left child of vertex  i*/
	private int left(int i) {
		return 3*i+3;
	}
	/** midChild returns the mid child of vertex  i*/
	private int mid(int i) {
		return 3*i+2;
	}
	/** parent returns the parent of vertex  i*/
	private int parent(int i) {
		return((3*i)-1)/3;
	}
	
	/**return the max value in the heap **/
	private int getmax() {
		return heap[0];
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
		
	private void swap(int i, int larg) {
		// TODO Auto-generated method stub
		int temp =heap[i];
		heap[i]=heap[larg];
		heap[larg]=temp ;
		
	}

	
	public boolean insert(int k) {
		boolean flag=true;
		return flag;
	}
	

	public int remove_max() {
		int max=0;
		return max;}

}




