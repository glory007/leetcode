//SOLVED.

// be really really careful about this kind of "easy" question. 

// areas to pay attention:
// 1. array out of bound (0)
// 2. all possible test cases.

// always review the codes at least once before submitting (or before done)!

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s == null || s=="") return 0;
        
        int i1 = s.length() - 1;
        
        while(i1>=0 && s.charAt(i1) == ' ' ){
            i1--;
        }
        
        if(i1<0){
            return 0;
        }
        
        int i2 = i1;
        while( i2>=0 && s.charAt(i2) != ' '){
            i2--;
        }
        
        return (i1-i2);
      
    }
}
