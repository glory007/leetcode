
// SOLVED! both small cases and large cases passed.

// be very careful about the interger overflow when you do 
// integer + integer or integer * integer

public class Sqrt{
    public int sqrt(int x) {

    	if(x==0 || x==1) return x;
    	
    	int s = 0;
    	int e = x;
    	while(true){
    		if(e-s <=1)
    			return s;
    		
    		int m = (s+e)/2;
    		
    		if(m < x/m){ // cannot use m*m < x here since it will cause overflow.
    			s = m;
    		}
    		else if(m > x/m){
    			e = m;
    		}
    		else{
    			return m;
    		}
    		
    	}
    	
    }

}