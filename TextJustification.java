/*
 * passed both small and large cases.
 * be careful of edge cases (one line only contains one single word...)
 */

import java.util.ArrayList;

/*
 * Text Justification
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.
Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
 */

public class TextJustification {
	public static void main(String[] args){
		String[] words = new String[]{"This", "is", "an"};
		
		for(String x : fullJustify(words, 16)){
			System.out.println(x);
		}
	}
	
    public static  ArrayList<String> fullJustify(String[] words, int L) {
    	
    	ArrayList<String> res = new ArrayList<String>();
    	
    	int i = 0;
    	int l = 0;
    	int count = 0;
    	while ( i < words.length ){

    		if(l + words[i].length() + count <= L){
    			l += words[i].length();
    			i++;
    			count++;
    		}
    		else{
    			String tmp = words[i - count];
                if(count>1){
                	int space = (L - l) / (count - 1);
        			int space2 = (L - l) % (count - 1);
        			for(int k = i - count + 1; k < i; k++){
        				if( k - (i-count) <= space2){
        					tmp += get(space+1) + words[k];
        				}
        				else{
        					tmp += get(space) + words[k];
        				}
        			}
    			}
                else{
                	tmp+= get(L-tmp.length());
                }
    			res.add(tmp);
    			l = 0 ;
    			count = 0;
    		}
    	}
    	
    	// last line
    	String tmp2 = words[words.length - count]; 
    	for(int k = words.length - count + 1; k < words.length; k++){
    		tmp2 += " "+words[k];
    	}

		res.add(tmp2 + get(L-tmp2.length()));
    	return res;
    }

	private static String get(int i) {
		String s = "";
		for(int m = 0 ; m < i; m++){
			s+=" ";
		}
		return s;
	}

}
