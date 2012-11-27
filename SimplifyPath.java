import java.util.Stack;

// SOLVED!

public class SimplifyPath {
    public String simplifyPath(String path) {
        path = path + "/";
        Stack<String> s = new Stack<String>();
        
        int prev = 0; 
        
        while(true){
            int curr = path.indexOf("/", prev+1);
            if(curr == -1) break;
            if(curr == prev+1){
            	prev = curr;
                continue;
            }
            String tmp = path.substring(prev+1, curr);
            prev = curr;
            if(tmp.equals(".")) continue;
            
            if(tmp.equals("..")){
                if(s.isEmpty()) continue;
                s.pop();
            }
            else{
                s.push(tmp);
            }
        }
        
       if(s.isEmpty()) return "/";
        
       String r = "";
       while(!s.isEmpty()){
    	   r = s.pop() + "/" + r;
       }
       String r2 = "/" + r;
       return r2.substring(0, r2.length()-1); 
       
    }
}