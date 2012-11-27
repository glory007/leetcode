// passed! one try. both small and large cases.

/*
 *  things to consider:
 *  1. negative integer
 *  2. integer overflow
 */

public class ReverseInteger {
	
    public int reverse(int x) {
    	if(x < 0) return -reverse(-x);
    	int r = 0;
    	while(x!=0){
    		int t = x % 10;
    		r = r*10 + t;
        	x /= 10;	
    	}
        
    	return r;
    }

}
