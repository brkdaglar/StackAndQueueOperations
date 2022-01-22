import java.util.ArrayList;
import java.util.List;

public class Stack{
	
	  List<Integer> stackArrayL = new ArrayList<>();   // a arrayList for create stack
	
      public Stack() {
    	
    	    	  
      }

      public void push(int number) {       // add numbers to top  
    	     stackArrayL.add(number);
      }
      
      public boolean isEmpty() {           // checks whether the stack is empty
    	  if (stackArrayL.isEmpty()) {
    		  return true;
    	  }else {
    		  return false;
    	  }
    	  
      }
      
      public int peek() {                   // returns to the top element of the stack 
    	  return stackArrayL.get(stackArrayL.size()-1);
      }
      
      public int pop() {                    // returns to the top element of the stack and delete top element
    	  if (!isEmpty()) { 
              int popNumber = stackArrayL.get(stackArrayL.size() - 1);
              stackArrayL.remove(stackArrayL.size() - 1);         
              return popNumber;
         } else {
              System.out.println( "There are not so many elements in stack for commands");
              return -1;
         }
    	  
      }
}
	


