// SOVLED BUT NOT BY MY CODES

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] agrs){
		String s = "()(()";
		System.out.println(longestValidParentheses(s));
	}
	
	// another way to solve this problem. 
	// two passes, without using extra storage.
	public static int longestValidParentheses2(String s){
		// first pass from left to right
		int max = 0;
		int count = 0;
		int len = 0;
		for(int i = 0; i < s.length() ; i++){
			if(s.charAt(i)=='('){
				count++;
				len++;
			}
			if(s.charAt(i)==')'){
				count--;
				len++;
			}
			if(count==0 && len > max){
				max = len;
			}
			if(count < 0){
				len = 0;
				count = 0;
			}
		}
		
		count = 0;
		len = 0;
		for(int i = s.length()-1; i >=0 ; i--){
			if(s.charAt(i)==')'){
				count++;
				len++;
			}
			if(s.charAt(i)=='('){
				count--;
				len++;
			}
			if(count==0 && len > max){
				max = len;
			}
			if(count < 0){
				len = 0;
				count = 0;
			}
		}
		return max;
	}
	

	public static int longestValidParentheses(String s) {
       Stack<Integer> stack = new Stack<Integer>();
       int len = 0;
       int maxLen = 0;
       int startIndex = s.length();
       for(int i = 0; i < s.length(); ++i) {
          if(s.charAt(i) == '(') {
              stack.push(i);
              continue;
          }
          
          if(stack.isEmpty()) {
              startIndex = s.length();
          } else {
              startIndex = Math.min(stack.peek(), startIndex);
              stack.pop();
              
              if(stack.isEmpty()) {
                  len = i - startIndex + 1;
              } else {
                  len = i - stack.peek();
              }
              maxLen = Math.max(maxLen, len);
          }
       }
       return maxLen;
  }

}