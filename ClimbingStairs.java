// solved. both small and large cases.

public class ClimbingStairs {
    public int climbStairs(int n) {
    	
    	if(n==0 || n==1) return n;
    	
    	int prev1 = 1;
    	int prev2 = 1;
    	
    	for(int i = 2; i <=n; i++){
    	    int tmp = prev1;
    		prev1 = prev2;
    		prev2 = tmp + prev2;
    	    
    	}
    	
    	return prev2;
    	
    }
}