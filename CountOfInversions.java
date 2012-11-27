// ideas. divide and conquer (similar with merge sort)

import java.util.ArrayList;


public class CountOfInversions {
	
	public static void main(String[] args){
		int[] a = new int[]{3, 5, 1, 4, 2}; 
		System.out.println(count(a));
	}
	
	public static int count(int[] a){
		return sort(a, 0, a.length-1);
	}
	
	public static int sort(int[] a, int s, int e){
		if(s==e) return 0;
		int m = (s+e)/2;
		int c1 = sort(a, s, m);
		int c2 = sort(a, m+1, e);
		int c3 = merge(a, s, m, e);
		return c1+c2+c3;
	}
	
	public static int merge(int[] a, int s, int m, int e){
		int count = 0;
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		for(int i = s; i <=m ; i++)
			a1.add(a[i]);
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		for(int i = m+1; i<=e; i++)
			a2.add(a[i]);
		
		int s1=0; int s2=0;
		int s3=s;
		while(s1 < a1.size() && s2 < a2.size()){
			if(a1.get(s1) < a2.get(s2)){
				count+=s2;
				a[s3++]=a1.get(s1++);
			}
			else{
				a[s3++]=a2.get(s2++);
			}
		}
		
		while(s1 < a1.size()){
			count+=a2.size();
			a[s3++] = a1.get(s1++);
		}
		
		while(s2 < a2.size()){
			a[s3++] = a2.get(s2++);
		}
		return count;
	}
}
