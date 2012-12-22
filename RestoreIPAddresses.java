// passed! both small and large cases!

import java.util.ArrayList;

/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses {
	
	public static void main(String[] args){
		String x = "255255255255";
		for(String s : restoreIpAddresses(x)){
			System.out.println(s);
		}
	}
	
    public static ArrayList<String> restoreIpAddresses(String s) {
    	ArrayList<String> r= new ArrayList<String>();
    	if(s.length() < 4) return r;
    	
    	for(int i = 2; i < s.length(); i++){
    		ArrayList<String> a1 = splitString(s.substring(0, i));
    		ArrayList<String> a2 = splitString(s.substring(i, s.length()));
    		
    		if(a1.size() > 0 && a2.size() > 0){
    			for(String x : a1){
    				for(String y: a2){
    					r.add(x + "." + y);
    				}
    			}
    		}
    	}
    	return r;
    }
    
    public static ArrayList<String> splitString(String s){
    	ArrayList<String> r= new ArrayList<String>();
    	if(s.length() <=1) return r;
    	
    	for(int i = 1; i < s.length(); i++){
    		if( i<=3 && (s.length()-i)<=3 
    				&& Integer.parseInt(s.substring(0,i)) >=0 
    				&& Integer.parseInt(s.substring(0,i)) <=255
    				&& Integer.parseInt(s.substring(i, s.length())) >= 0 
    				&& Integer.parseInt(s.substring(i, s.length())) <= 255){
    			
    			// also for case like "010", those are invalid cases.
    			if( !(i >=2 && s.charAt(0)=='0') && !(s.length() - i >=2 && s.charAt(i)=='0') ) 
    				r.add(s.substring(0,i)+"."+s.substring(i, s.length()) );
    		}
    	}
    	
    	return r;
    }
}
