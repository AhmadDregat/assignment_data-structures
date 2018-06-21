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
	
	public boolean insert(int k) {}
/**return the max value in the heap **/
	private int getmax() {
		return heap[0];
	}
	public int remove_max() {}


}


