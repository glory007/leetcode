// PASSED! AFTER several times of try...

/*
 * this kind of coding questions are boring and super tricky.
 * 
 * thing to be careful:
 * 1. overflow
 * 2. signed and unsigned integers (to make it even worse, java does not support unsigned types.)
 * 
 * 
 */

/*
 * Divide Two Integers
Divide two integers without using multiplication, division and mod operator.
 */

public class DivideTwoIntegers {
	
	public static void main(String[] args){
		System.out.println(divide(2147483647,0));
	}
	
	public static int divide(int a, int b){
		return divideLong(a,b);
	}

	// return a/b
	// the reason we need long is because java does not support unsigned int, so when a=Integer.MIN, -a will cause an overflow.
	public static int divideLong(long a, long b){
		if(a > 0 && b < 0){
			return -divideLong(a, -b); 
		}
		if(a < 0 && b > 0){
			return -divideLong(-a, b);
		}
		if(a< 0 && b < 0){
			return divideLong(-a,-b);
		}
			
		if(a == 0) return 0;
		if(a < b) return 0;
		
		long r = b;
		long count = 1;
		while(r < a){
			count*=2;
			r+=r;
		}
		
		if(r==a) return (int)count;
		return (int)(count/2) + divideLong(a - (int)(r/2),b);
	}
}
