
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

	public class ReadFile {

	        public static Object readFile(String path) {                      // method for reading files
	        	try {
	    	    	int i = 0;
	    	    	int lenght = Files.readAllLines(Paths.get(path)).size();
	    	    	String [] results = new String[lenght];
	    	           for (String line : Files.readAllLines(Paths.get(path))) {
	                        results[i++]= line;
	    	           }
	                return results;	
	    	    } 
	    	    catch (IOException e) {
	    	    	e.printStackTrace();
	    	    	return null;
	    	    }
	        	
	        }
	        
	        
	 public static void writeFile(String a,String b) {             // method for writing files
	        	
		 try {
	  	              FileWriter myWriter = new FileWriter(a);
	  	              myWriter.write(b);
	  	              myWriter.close();
	  	      } catch (IOException e) {
	  	            System.out.println("An error occurred.");
	  	            e.printStackTrace();
	  	          }
	        }
	 
	 
	 public static void appendWrite(String a,String b) throws IOException {  // method for writing files
		    File file = new File(a);
			FileWriter fr = new FileWriter(file, true);
			fr.write(b);
			fr.close();
		 
	 }
	 
	 public static void deleteFile(String a) {
		      
		 try {         
			 File f= new File(a);           
			 if(f.delete())  {   
		 
			 } 
			 else {  
			 }  
		 }  
		 catch(Exception e)  
		 {  
		 e.printStackTrace();  
		 }  
		 }  
			  
	 
	
	 
		
		
}
