import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
 * http://www.mathblog.dk/project-euler-82-find-the-minimal-path-sum-from-the-left-column-to-the-right-column/
 * NOTE: This problem is a more challenging version of Problem 81.
The minimal path sum in the 5 by 5 matrix below, by starting in any cell in the left column and finishing in any cell in the right column, and only moving up, down, and right, is indicated in red and bold; the sum is equal to 994.
	
131	673	234	103	18
201	96	342	965	150
630	803	746	422	111
537	699	497	121	956
805	732	524	37	331

Find the minimal path sum, in matrix.txt (right click and ‘Save Link/Target As…’), a 31K text file containing a 80 by 80 matrix, from the left column to the right column.
 */

// even more challenging one?
// http://www.mathblog.dk/project-euler-83-find-the-minimal-path-sum-from-the-top-left-to-the-bottom-right-by-moving-left-right-up-and-down/


public class MinimumPathSumII {
	
	
	public static void main(String[] args){
		int[][] a = new int[][] {{131	,673	,234	,103,18},
				{201,	96,	342	,965	,150},
				{630,	803,	746	,422	,111},
				{537,	699,	497	,121	,956},
				{805,	732,	524,	37	,331}};
		
		System.out.println(run(a));
		
		int[][] b = new int[80][80];
		 try{
			  FileInputStream fstream = new FileInputStream("/Users/jlli/Desktop/matrix.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  int j = 0;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			      String[] s = strLine.split(",");
			      for(int i = 0 ; i < 80; i++){
			    	  b[j][i] = Integer.parseInt(s[i]);
			      }
			      j++;
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		 
			System.out.println(run(b));
	}
	
	public static int run(int[][] a){
		int[] t = new int[a.length];
		
		for(int j = 0; j < a.length; j++){
			t[j] = a[j][0];
		}
		
		for(int i = 1; i < a.length; i++){
			
			// traverse down
			t[0] = t[0] + a[0][i];
			for(int j = 1; j < a.length; j++){
				t[j] = (t[j-1] < t[j]) ? t[j-1] + a[j][i] : t[j] + a[j][i];
			}
			
			// traverse up
			for(int j = a.length -2; j>=0; j--){
				t[j] = t[j+1] + a[j][i] < t[j] ?  t[j+1] + a[j][i] : t[j];
			}
			
		}
		
		int min = t[0];
		for(int i = 1; i < t.length; i++){
			min = t[i] < min ? t[i] : min;
		}
		return min;
		
	}

}
