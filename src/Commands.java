import java.io.IOException;

public class Commands {
	    
	   ProcessStack procs = new ProcessStack();	
       ProcessQueue procq = new ProcessQueue();
	
	   
	   public Commands(String command) throws NumberFormatException, IOException {            // reads argument file and apply methods.
		  
		      String[]   a  = (String[]) ReadFile.readFile(command);
	          for (String line:a) {
	        	   String[] k = line.split(" ");
	        	   if     (k[0].equals("S")){
	        		   if (k[1].equals("removeGreater")) {
	        			   procs.removeGreatStack(Integer.parseInt(k[2]));	        			   
	        		   }
	        		   if (k[1].equals("calculateDistance")) {
	        			   procs.calculateDistanceStack();
	        			   
	        		   }
	        		   if (k[1].equals("addOrRemove")) {
	        			   procs.addOrremoveStack(Integer.parseInt(k[2]));
	        			   
	        		   }
	        		   if (k[1].equals("reverse")) {
	        			   procs.reverseStack(Integer.parseInt(k[2]));
	        			   
	        		   }
	        		   if (k[1].equals("sortElements")) {
	        			   procs.sortElementsStack();
	        			   
	        		   }
	        		   if (k[1].equals("distinctElements")) {
	        			   procs.distinctElementsStack();
	        			   
	        		   }
	        		   
	        	   }
	        	   else if(k[0].equals("Q")){
                       if (k[1].equals("removeGreater")) {
                    	   procq.removeGreatQueue(Integer.parseInt(k[2]));
	        			   
	        		   }
                       if (k[1].equals("calculateDistance")) {
                    	   procq.calculateDistanceQueue();
	        			   
	        		   }
                       if (k[1].equals("addOrRemove")) {
                    	   procq.addOrremoveQueue(Integer.parseInt(k[2]));
	        			   
	        		   }
	        		   if (k[1].equals("reverse")) {
	        			   procq.reverseQueue(Integer.parseInt(k[2]));
	        			   
	        		   }
	        		   if (k[1].equals("sortElements")) {
	        			   procq.sortElementsQueue();
	        			   
	        		   }
	        		   if (k[1].equals("distinctElements")) {
	        			   procq.distinctElementsQueue();
	        			   
	        		   }
	        	   }
	        	  
	          }
	          procs.uptadeStack();
	          procq.uptadeQueue();
	   }

}
