import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Imagine you have a special keyboard with the following keys:
A
Ctrl+A
Ctrl+C
Ctrl+V
where CTRL+A, CTRL+C, CTRL+V each acts as one function key for “Select All”, “Copy”, and “Paste” operations respectively.
If you can only press the keyboard for N times (with the above four keys), please write a program to produce maximum numbers of A. If possible, please also print out the sequence of keys.
That is to say, the input parameter is N (No. of keys that you can press), the output is M (No. of As that you can produce).
 */
public class CtrlACtrlC {
	
	static class Pair{
		long v1;
		long v2;
		public Pair(long v1, long v2){
			this.v1 = v1;
			this.v2 = v2;
		}
	}
	
	private Map<Integer, Set<Pair>> map = new HashMap<Integer, Set<Pair>>();
	
    public Set<Pair> getMax(int n){
        if(n <= 3){
            Set<Pair> s = new HashSet<Pair>();
            Pair p = new Pair(n,1);
            s.add(p);
            return s ;
        }
        
        Set<Pair> r1;
        if(map.containsKey(n-1)){
        	r1 = map.get(n-1);
        }
        else{
        	r1 = getMax(n-1);
        	map.put(n-1, getCopy(r1));
        }
        
        for(Pair p: r1){
            p.v1 += p.v2 ;
        }
        
        Set<Pair> r2 ;
        if(map.containsKey(n-3)){
        	r2 = map.get(n-3);
        }
        else{
        	r2 = getMax(n-3);
        	map.put(n-3, getCopy(r2));
        }
        
        for(Pair p: r2){
            p.v2 = p.v1;
        }
        
        r1.addAll(r2);
        dedupe(r1);
        return r1;
    }
    
    private void dedupe(Set<Pair> r1) {
    	Set<Pair> r2 = new HashSet<Pair>();
    	
    	for(Pair p1 : r1){
    		for(Pair p2 : r1){
    			if ((p1.v1 < p2.v1 && p1.v2 <= p2.v2) || (p1.v1 <= p2.v1 && p1.v2 < p2.v2) ){
    				r2.add(p1);
    				break;
    			}
    		}
    	}
    	
    	r1.removeAll(r2);
		
	}

	private Set<Pair> getCopy(Set<Pair> r1) {
    	Set<Pair> r = new HashSet<Pair>();
    	for(Pair p : r1){
    		Pair p2 = new Pair(p.v1, p.v2);
    		r.add(p2);
    	}
    	return r;
	}

	public static long getMaxCount(int n){
    	CtrlACtrlC x = new CtrlACtrlC();
        Set<Pair> s = x.getMax(7);
        
        long current = Integer.MIN_VALUE;
        
        for(Pair p : s){
            if(current < p.v1){
                current = p.v1;
            }
        }
        return current;
    }
    
    
    public static void main(String[] args){
    	long v = getMaxCount(8);
    	System.out.println(v);
    }

}
