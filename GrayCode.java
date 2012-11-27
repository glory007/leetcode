// solved. both small and big cases

import java.util.ArrayList;

/*
 * Gray Code
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
 */
public class GrayCode {
	
	public static void main(String[] args){
		
		for(int i : grayCode(1)){
			System.out.println(i);
		}
	}
	
	public static ArrayList<Integer> grayCode(int n){
		ArrayList<Integer> a = new ArrayList<Integer>();
		if(n==0){
			a.add(0);
			return a;
		}
		if (n==1){
			a.add(0); a.add(1);
			return a;
		}
		ArrayList<Integer> b = grayCode(n-1);
		for(int i = b.size()-1; i >=0; i--){
			b.add(b.get(i)+(int)Math.pow(2, n-1));
		}
		return b;
	}

}
