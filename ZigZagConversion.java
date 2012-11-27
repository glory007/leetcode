// SOLVED! both small and large cases

import java.util.ArrayList;


public class ZigZagConversion {

	public static void main(String [] args){
		System.out.println(convert("PAYPALISHIRING",1));	
	}
	
    public static String convert(String s, int nRows) {
    	
    	if(s==null || s.equals("")) return "";
    	if(nRows==1) return s;
    	ArrayList<ArrayList<Character>> r = new ArrayList<ArrayList<Character>>();
    	
    	for(int i = 0 ;i <nRows; i++){
    		ArrayList<Character> tmp = new ArrayList<Character>();
    		r.add(tmp);
    	}
    	
    	for(int i = 0 ; i < s.length(); i++){
    		if (i % (nRows + nRows - 2) >= 0 && i % (nRows + nRows - 2) < nRows){
    			r.get(i % (nRows + nRows - 2)).add(s.charAt(i));
    		}
    		else{
    			int tmp = i % (nRows + nRows - 2);
    			r.get(nRows - 2 - tmp % nRows).add(s.charAt(i));
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(ArrayList<Character> a : r){
    		for(char x : a){
    			sb.append(x);
    		}
    	}
    	return sb.toString();
    }

}
