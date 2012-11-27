import java.util.Date;


public class Scratch {
	
	   public static void main(String[] args){
	        long z;
	        Date a=new Date();
	        for(long i=0; i<10;i++)
	            for(long j=0;j<10000000;j++)
	                 z=i*j;
	        Date b=new Date();
	        System.out.println(b.getTime()-a.getTime());
	        
	    }

}
