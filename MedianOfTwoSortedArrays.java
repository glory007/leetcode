// SOLVED! BOTH SMALL AND BIG CASES!

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class MedianOfTwoSortedArrays {
	
//	public static void main(String[] arg){
//		
//		int[] A1 = new int[] {1};
//		int[] B1 = new int[] {2,3,4};
//		
//		System.out.println(findMedianSortedArrays(B1,A1));
//		
//		try{
//			  FileInputStream fstream = new FileInputStream("/Users/jlli/Desktop/test2.txt");
//			  // Get the object of DataInputStream
//			  DataInputStream in = new DataInputStream(fstream);
//			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
//			  String strLine;
//			  //Read File Line By Line
//			  while ((strLine = br.readLine()) != null)   {
//				  
//				  String[] a = strLine.split("\t");
//				  
//			  // Print the content on the console
//			  
//			  String b= a[0].replaceAll("\\], \\[", "\t").replace('[', ' ').replace(']', ' ').trim();
//			  String[] c = b.split("\t");
//			  String[] d = c[0].split(",");
//			  int[] A = new int[d.length];
//			  for(int i = 0; i < d.length; i++){
//				  A[i] = Integer.parseInt(d[i]);
//			  }
//			  
//			  String[] e = c[1].split(",");
//			  int[] B = new int[e.length];
//			  for(int i = 0; i < e.length; i++){
//				  B[i] = Integer.parseInt(e[i]);
//			  }
//			 
//			  System.out.println (b); 
//			  System.out.println(findMedianSortedArrays(A,B));
//			  }
//			  //Close the input stream
//			  in.close();
//			    }catch (Exception e){//Catch exception if any
//			  System.err.println("Error: " + e.getMessage());
//			  }
//
//		
//	}
	
	
    public static double findMedianSortedArrays(int A[], int B[]) {
    	int m = A.length;
    	int n = B.length;
    	
    	if(m==0) return (n%2==1) ? B[n/2] : (B[n/2-1]+B[n/2])/2.0;
    	if (n==0) return findMedianSortedArrays(B,A);
    	
    	int start = (m-n) / 2 > 0 ? (m-n)/2:0;
    	int end = (m+n)/2 > m-1 ? m-1 : (m+n)/2;
    	
    	// odd
    	if((m+n) % 2 == 1){
    		return findMedian(A,B,start,end, true);
    	}
    	else{
    		return findMedian(A,B,start,end, false);
    	}
    }
    
    // first only consider odd case.
    public static double findMedian(int A[], int[] B, int start, int end, boolean isOdd ){
    	int m = A.length;
    	int n = B.length;
    	
    	if(start>end){
    		return findMedian(B,A,(n-m) / 2 > 0 ? (n-m)/2:0, (m+n)/2 > n-1 ? n-1 : (m+n)/2, isOdd);
    	}
    	int middle = (start+end)/2;
    	int p =  (m+n)/2 - 1 - middle ;
    	
    	if ( (p==-1 || A[middle] >= B[p]) && (p==n-1 || A[middle]<=B[p+1])){
   			if(isOdd)
   				return A[middle];
   			else{
   				if(p==-1)
   					return ((double)A[middle] + (double)A[middle-1])/2.0;
   				else if(middle==0){
   					return ((double)A[middle] + (double)B[p])/2.0;
   				}
   				else{
   					int tmp = A[middle-1] > B[p] ? A[middle-1] : B[p];
   					return ((double)A[middle] + (double)tmp)/2.0;
   				}
   				
   			}
    	}
    	else if( p!=-1 && A[middle] < B[p]){
    		return findMedian(A,B, middle+1, end,isOdd);
    	}
    	else{
    		return findMedian(A,B,start, middle-1,isOdd);
    	}
    }
}
