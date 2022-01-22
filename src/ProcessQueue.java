import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessQueue {
	   
	   static Queue que = new Queue();
	   
	   public ProcessQueue() {                                                  // in this constructor , reads file and enqueue elements to queue
		      String[]   a     = (String[]) ReadFile.readFile("queue.txt");
	          for (String line:a) {
		           String[] k = line.split(" ");
		           for (int i=0;i<k.length;i++) {
			            que.enqueue(Integer.parseInt(k[i]));
		           }

	          }
	   }
	   
	   public void removeGreatQueue(int value) throws IOException {            
		      List<Integer> dequeueList = new ArrayList<>();
		      int sized = que.size();
		      for (int i = 0 ; i<sized ; i++) {
		    	   int dequeueElement = que.dequeue();
		    	   if (dequeueElement<=value) {
		    		   dequeueList.add(dequeueElement);
		    	   }		    	   
		      }

		      for (int i = 0 ; i<dequeueList.size()  ;i++) {
			       que.enqueue(dequeueList.get(i));			 
		      }
		      ReadFile.appendWrite("queueOut.txt", "\nAfter removeGreater "+String.valueOf(value)+":");
		      printQueue();
	   }
       
	   public void calculateDistanceQueue() throws IOException {
		      List<Integer> dequeueList = new ArrayList<>();
		      List<Integer> enqueueList = new ArrayList<>();
		      int sized = que.size();
		      for (int i = 0 ; i<sized ; i++) {
		    	   int dequeueElement = que.dequeue();
		    	   dequeueList.add(dequeueElement);
		    	   enqueueList.add(dequeueElement);
		      }
		      int total = 0;
		      for (int i = dequeueList.size()-1 ; i>=0  ;i--) {
		    	   int frontValue = dequeueList.get(i);
		    	   dequeueList.remove(i);
		    	   for (int j = dequeueList.size()-1 ; j>=0  ;j--) {
		    		    int rearValue = dequeueList.get(j);
		    		    total += Math.abs(frontValue-rearValue);			 
			      }		 
		      }
		      for (int i = 0 ; i<enqueueList.size()  ;i++) {
			       que.enqueue(enqueueList.get(i));			 
		      }
		      ReadFile.appendWrite("queueOut.txt","\nAfter calculateDistance: \nTotal distance="+String.valueOf(total));

	   
	   }
	   
	   public void addOrremoveQueue(int elements) throws IOException  {
		      if      (elements>0) {
		    	      for (int i = 0 ; i<elements; i++) {
		    		       ThreadLocalRandom random = ThreadLocalRandom.current();		    			
	    		           int randomValue = random.nextInt(1, 50);
	    		           que.enqueue(randomValue);
		    	      }
		    	  
		      }
		      else if (elements<0) {
		    	       for (int i = 0 ;i>elements;i--) {
		    	    	    que.dequeue();
		    	       }	    	  
		      }	
		      ReadFile.appendWrite("queueOut.txt","\nAfter addOrRemove "+String.valueOf(elements)+":");
		      printQueue();
	   }
	   
	   public void reverseQueue(int elements) throws IOException {
		      List<Integer> dequeueList = new ArrayList<>();
		      List<Integer> reverseList = new ArrayList<>();
		      for (int i = 0 ; i<elements ; i++) { 
		    	   int dequeueElement = que.dequeue();
                   reverseList.add(dequeueElement);
		      }
		      int sized = que.size();
		      for (int i = 0 ; i<sized ; i++) {
		    	   int dequeueElement = que.dequeue();
		    	   dequeueList.add(dequeueElement);
		      }
		      for (int i = reverseList.size()-1 ; i>=0 ; i--) {
		    	   que.enqueue(reverseList.get(i));
		      }
		      for (int i = 0 ; i<dequeueList.size(); i++) {
		    	   que.enqueue(dequeueList.get(i));		    	  
		      }
		      ReadFile.appendWrite("queueOut.txt","\nAfter reverse "+String.valueOf(elements)+":");
		      printQueue();
	   }
	   
       public void sortElementsQueue() throws IOException {
    	      List<Integer> dequeueList = new ArrayList<>();
    	      
		      int sized = que.size();
		      for (int i = 0 ; i<sized ; i++) {
		    	   int dequeueElement = que.dequeue();
		    	   dequeueList.add(dequeueElement);		    	   		    	   
		      }		      
		      Collections.sort(dequeueList);
		      for (int i = 0 ; i<dequeueList.size()  ;i++) {
			       que.enqueue(dequeueList.get(i));			 
		      }
		      ReadFile.appendWrite("queueOut.txt", "\nAfter sortElements:");
		      printQueue();
       }
       
       public void distinctElementsQueue() throws IOException {
    	      List<Integer> dequeueList = new ArrayList<>();
    	      List<Integer> distinctCounter = new ArrayList<>();
    	      
    	      int sized = que.size();
		      for (int i = 0 ; i<sized ; i++) {
		    	   int dequeueElement = que.dequeue();
		    	   dequeueList.add(dequeueElement);
		    	   if (distinctCounter.contains(dequeueElement)==false) {
		    		   distinctCounter.add(dequeueElement);
		    	   }
		      }
		      for (int i = 0 ; i<dequeueList.size()  ;i++) {
			       que.enqueue(dequeueList.get(i));			 
		      }
		      ReadFile.appendWrite("queueOut.txt", "\nAfter distinctElements:"+"\nTotal distinct="+String.valueOf(distinctCounter.size()+":"));

       }
       
       public static void printQueue() throws IOException {               // print elements in queue
    	      List<Integer> dequeueList = new ArrayList<>();
    	      int sized = que.size();
    	      ReadFile.appendWrite("queueOut.txt", "\n");
		      for (int i = 0 ; i<sized ; i++) {
		    	   int dequeueElement = que.dequeue();
		    	   dequeueList.add(dequeueElement);
		    	   ReadFile.appendWrite("queueOut.txt",String.valueOf(dequeueElement)+" ");
		      }
		      for (int i = 0 ; i<dequeueList.size()  ;i++) {
			       que.enqueue(dequeueList.get(i));			 
		      } 	   
       }
       
       public void uptadeQueue() throws IOException {                     // uptade queue.txt
    	      List<Integer> dequeueList = new ArrayList<>();
 	          int sized = que.size();
 	          ReadFile.deleteFile("queue.txt");
 	          for (int i = 0 ; i<sized ; i++) {
		    	   int dequeueElement = que.dequeue();
		    	   dequeueList.add(dequeueElement);
		    	   ReadFile.appendWrite("queue.txt",String.valueOf(dequeueElement)+" ");
 	          }
 	          for (int i = 0 ; i<dequeueList.size()  ;i++) {
			       que.enqueue(dequeueList.get(i));			 
		      } 
    	      
       }
	   
	   
	   
	   
	   
}
