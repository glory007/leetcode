// SOLVED! both small and large cases passed!

public class Power {
	
	
	public static void main(String[] args){
		System.out.println(pow(1.0f,-2147483648));
	}
	
	// iteratively
	 public static double pow_smarter(double x, int n)
	 {
	     if(n<0) return 1/pow_smarter(x,-n);
	     double odd = 1.0f;
	     while (n>0){
	         if ((n&1) ==1) odd *= x;
	         x *= x;
	         n >>=1;
	     }
	     return odd;
	 }
        
	
		public static double pow_iterative(double x, int n) {
	        if(n<0) return 1/pow_iterative(x,-n);
	        int c = 0;
	        int tmp = n;
	        while(tmp>0){
	            c++;
	            tmp=tmp>>1;
	        }
	        
	        double result = 1.0f;
	        
	        for(int i = c-1; i>=0; i--){
	            result = result * result;
	            if (((n >> i) & 1) == 1){
	                result *= x;
	            }
	        }
	        return result;
	    }
	
	// how to handle overflow.
	public static double pow(double x, int n) {
		return powLong(x,n);
    }
	
	// how to handle overflow.
	public static double powLong(double x, long n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n<0) return 1/(powLong(x,-n));
        
        double tmp = powLong(x, n/2);
        return tmp*tmp*(powLong(x, n%2));
    }
	
	
	
}