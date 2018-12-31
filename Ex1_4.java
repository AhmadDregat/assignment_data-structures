import java.util.LinkedList;
import java.util.Queue;

	 
	public  class Ex1_4 
	{
	    static Queue<Integer> q = new LinkedList<Integer>();
	     
	    // Push operation
	    public static void push(int x) 
	    {  int size = q.size();// get previous size of queue
	         q.add(x);// Add current element
	     
	        for (int j = 0; j < size; j++) {
	            int y = q.remove();
	            q.add(y);
	        }
	    }
	     
	    // Removes the top element
	 public static int pop() 
	    {
	        if (q.isEmpty()) 
	        {   return -1;}
	        
	        int c = q.remove();
	        return c;
	    }
	     
	  
	     
	    // Returns true if Stack is empty else false
	 public static boolean isEmpty() 
	    {
	        return q.isEmpty();
	    }
	}