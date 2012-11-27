import java.util.HashMap;
import java.util.Map;

/*
 * Count and Say
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
	
	public static void main(String[] args){
		System.out.print(new CountAndSay().countAndSay_concise_version(7));
	}

	private HashMap<String, String> map = new HashMap<String, String>();
	
	public String countAndSay_concise_version(int n){
		String r = "1";
		
		for(int i = 2; i<=n; i++){
			r = countAndSay_concise_version(r);
		}
	   return r;
	}
	
	public String countAndSay_concise_version(String s){
		
		StringBuilder r = new StringBuilder();
		char actual = s.charAt(0);
		int times = 1;
		
		String numbers = s.substring(1) + " ";
		
		for(char num : numbers.toCharArray()){
			if(num != actual){
				r.append(times);
				r.append(actual);
				actual = num;
				times = 1;
			}
			else{
				times++;
			}
		}

		return r.toString();
		
	}
	
	public String countAndSay(int n) {
		initialize(map);
		String r = "1";
		
		for(int i = 2; i<=n; i++){
			r = countAndSay(r, map);
		}
	   return r;
	}
	
	private String countAndSay(String s, Map<String, String> map){
		if(s.equals(""))
			return "";
		
		if(map.containsKey(s))
			return map.get(s);
		
		if(s.length() >= 3 && map.containsKey(s.substring(0, 3))){
			return map.get(s.substring(0, 3)) + countAndSay(s.substring(3), map);
		}
		
		if(s.length() >= 2 && map.containsKey(s.substring(0, 2))){
			return map.get(s.substring(0, 2)) + countAndSay(s.substring(2), map);
		}
		
	    return map.get(s.substring(0, 1)) + countAndSay(s.substring(1), map);
		
	}

	private void initialize(HashMap<String, String> map2) {
		map2.put("1", "11");
		map2.put("2", "12");
		map2.put("3", "13");
		
		map2.put("11", "21");
		map2.put("22", "22");
		map2.put("33", "23");
		
		map2.put("111", "31");
		map2.put("222", "32");
		map2.put("333", "33");
	}
}
