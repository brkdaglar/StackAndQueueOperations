import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessStack {
	
	   static Stack st = new Stack();
	
	   public ProcessStack() {                                                //in this constructor , reads file and push elements to stack
		      String[]   a     = (String[]) ReadFile.readFile("stack.txt");
  	          for (String line:a) {
  		           String[] k = line.split(" ");
  		           for (int i=k.length - 1;i>=0 ;i--) {
  			            st.push(Integer.parseInt(k[i]));
  		           }
  	          }
  	   }

	   public void removeGreatStack(int value) throws IOException {
		      List<Integer> popList = new ArrayList<>();
		      int sized = size();
		      for (int i = 0 ; i<sized ; i++) {
			       int poppedValue = st.pop();
			       if (poppedValue<=value) {
				       popList.add(poppedValue);			 
			       }
		      }
		      for (int i = popList.size()-1; i>=0 ;i--) {
			       st.push(popList.get(i));			 
		      }
		      ReadFile.appendWrite("stackOut.txt", "\nAfter removeGreater "+String.valueOf(value)+":" );
		      printStack();
	
	   }
	   
	   public void calculateDistanceStack() throws IOException {
		      List<Integer> popList = new ArrayList<>();
		      List<Integer> pushList= new ArrayList<>();
		      int sized = size();
		      for (int i = 0 ; i<sized ; i++) {
			       int poppedValue = st.pop();
				   popList.add(poppedValue);
				   pushList.add(poppedValue);
		      }
		      int total=0;
		      for (int i = popList.size()-1; i>=0 ;i--) {
		    	   int topValue = popList.get(i);
		    	   popList.remove(i);
		    	   for (int j = popList.size()-1; j>=0 ;j--) {
		    		    int nextValue = popList.get(j);
		    		    total += Math.abs(topValue-nextValue);		       		 
			       } 			       		 
		      }
		      for (int i = pushList.size()-1; i>=0 ;i--) {
			       st.push(pushList.get(i));			 
		      }
		      ReadFile.appendWrite("stackOut.txt","\nAfter calculateDistance:"+"\nTotal distance="+String.valueOf(total));
	   }
	   
	   public void addOrremoveStack(int elements) throws IOException  {
		      if     (elements>0) {
		    	      for(int i = 0 ; i<elements ; i++) {
		    		      ThreadLocalRandom random = ThreadLocalRandom.current();		    			
		    		      int randomValue = random.nextInt(1, 50);
		    		      st.push(randomValue);
		    	      }		   
		      }
		      else if(elements<0) {
		    	      for (int i = 0 ; i>elements ; i--) {
		    	    	  st.pop();		    	    	  
		    	      }			   
		      }
		      ReadFile.appendWrite("stackOut.txt", "\nAfter addOrRemove "+String.valueOf(elements)+":");
		      printStack();
	   }
	   
	   public void reverseStack(int elements) throws IOException {		      
		      List<Integer> popList = new ArrayList<>();
		      for (int i = 0 ; i<elements ; i++) {
                   int poppedElement = st.pop();
                   popList.add(poppedElement);

		      }
		      for (int i = 0 ; i<=popList.size()-1 ; i++) {
		    	   st.push(popList.get(i));
		      }
		      ReadFile.appendWrite("stackOut.txt","\nAfter reverse "+String.valueOf(elements)+":");
		      printStack();
		   
	   }
	   
	   public void sortElementsStack() throws IOException {
		      List<Integer> popList = new ArrayList<>();
		      int sized = size();
		      for (int i = 0 ; i<sized ; i++) {
			       int poppedValue = st.pop();
				   popList.add(poppedValue);			 
			       
		      }
		      Collections.sort(popList);
		      for (int i = popList.size()-1; i>=0 ;i--) {
			       st.push(popList.get(i));			 
		      }
		      ReadFile.appendWrite("stackOut.txt","\nAfter sortElements:");
		      printStack();
	   }
	   
	   public  void distinctElementsStack() throws IOException {
		      List<Integer> popList = new ArrayList<>();
		      List<Integer> distinctCounter = new ArrayList<>();
		      int sized = size();
		      for (int i = 0 ; i<sized ; i++) {
			       int poppedValue = st.pop();
				   popList.add(poppedValue);
				   if (distinctCounter.contains(poppedValue)==false) {
					   distinctCounter.add(poppedValue);					   
				   }			       
		      }
		      for (int i = popList.size()-1; i>=0 ;i--) {
			       st.push(popList.get(i));			 
		      }
		      ReadFile.appendWrite("stackOut.txt","\nAfter distinctElements:"+"\nTotal distinct element="+String.valueOf(distinctCounter.size()));
	   }
	   
	   public static void printStack() throws IOException {                // prints element in stack
		      List<Integer> popList = new ArrayList<>();
		      int sized = size();
		      ReadFile.appendWrite("stackOut.txt","\n");
		      for (int i = 0 ; i<sized ; i++) {
			       int poppedValue = st.pop();
				   popList.add(poppedValue);
				   ReadFile.appendWrite("stackOut.txt",String.valueOf(poppedValue)+" ");
		      }
		      for (int i = popList.size()-1; i>=0 ;i--) {
			       st.push(popList.get(i));			 
		      }		      
	   }
	   
	   public void uptadeStack() throws IOException {                       // uptade stack.txt
		      List<Integer> popList = new ArrayList<>();
		      int sized = size();
		      ReadFile.deleteFile("stack.txt");
		      for (int i = 0 ; i<sized ; i++) {
			       int poppedValue = st.pop();
				   popList.add(poppedValue);
				   ReadFile.appendWrite("stack.txt",String.valueOf(poppedValue)+" ");
		      }
		      for (int i = popList.size()-1; i>=0 ;i--) {
			       st.push(popList.get(i));			 
		      }			      
	   }
	   
	   public static int size() {                             // returns the size of stack                   
		      List<Integer> popList = new ArrayList<>();
		      int size = 0;
		      while (!st.isEmpty()) {
		    	    int poppedValue = st.pop();
				    popList.add(poppedValue);
				    size++;
		      }
		      for (int i = popList.size()-1; i>=0 ;i--) {
			       st.push(popList.get(i));			 
		      }	
		      return size;
		      
	   }
       

}     

