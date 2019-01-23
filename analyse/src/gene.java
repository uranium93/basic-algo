import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class gene {
static int n =10;
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		 PrintWriter writer = new PrintWriter("src/array.txt");
		 for(int i=0; i<n;i++) {
			 for(int j=0; j<n;j++){
			 writer.print(" "+(int)(Math.random()*94));
			    
			   

			 }
			 writer.println(); 
		 }
		 writer.close();
		 
	}

}
