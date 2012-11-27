// SOVLED BUT NOT BY MY CODES

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] agrs){
		
		String s = "()(()";
		
		System.out.println(longestValidParentheses(s));
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