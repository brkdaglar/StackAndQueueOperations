import java.util.ArrayList;
import java.util.List;

public class Queue {
	
	   List<Integer> queueArrayL = new ArrayList<>(); // a array for create queue
	
	   public Queue() {
		
	   }
	   
	   public void enqueue(int value) {              // add numbers to rear
		   queueArrayL.add(value);	   
	   }
	   
	   public boolean isEmpty() {                    // checks whether the queue is empty
		   if (queueArrayL.isEmpty()) {
	    		  return true;
	    	  }else {
	    		  return false;
	    	  }
	    	  
	   }
	   
	   public int peek() {                           // returns to the front element in queue
		   return queueArrayL.get(0);
	   }
	   
	   public int dequeue() {                        // returns to the front element in queue and delete front element
		   if (!isEmpty()) { 
	              int dequeueNumber = queueArrayL.get(0);
	              queueArrayL.remove(queueArrayL.get(0));         
	              return dequeueNumber;
	         } else {
	              System.out.println("There are not so many elements in queue for commands");
	              return -1;
	         }
	   }
	      
	   public int size() {                           // returns the size of queue
	    	  return queueArrayL.size();
	      }
	      
		   
	   

}
