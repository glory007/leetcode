import java.util.ArrayList;

// SOLVED:

public class NQueens {
	
	private int count=0;
	 public int totalNQueens(int n) {
		 this.count=0;
		 ArrayList<String[]> s =  solveNQueens(n);
		 return this.count;
	        
	    }
	
	public static void main(String[] args){
		NQueens q = new NQueens();
		
		ArrayList<String[]> c = q.solveNQueens(14);
		
		for(String[] s : c){
			for(String s1: s){
				System.out.println(s1);
			}
			System.out.println("");
		}
	}
	
    public ArrayList<String[]> solveNQueens(int n) {
        char[][] c = new char[n][n];
        //init
        for(int i = 0; i < n; i++){
            for(int j = 0; j <n; j++){
                c[i][j]='.';
            }
        }
        ArrayList<String[]> a = new ArrayList<String[]>();
        solve(c,0,a);
		return a;
        
    }
    
    public void mark(char[][] c, int i, int j){
        c[i][j] = 'Q';
        set(c, i, j, true);
        
    
    }
    
    public void unmark(char[][] c, int i, int j){
        c[i][j] = '.';
        set(c, i, j, false);
        
    
    }
    
    public void set(char[][] c, int i, int j, boolean set){
        int i1 = i+1; int j1 = j+1;
        while(i1 >= 0 && i1 <= c.length-1 && j1 >=0 && j1 <= c.length-1){
        	if (set)
            c[i1++][j1++]++;
        	else{
        		c[i1++][j1++]--;
        	}
        } 
        
        i1 = i -1; j1 = j+1;
        while(i1 >= 0 && i1 <= c.length-1 && j1 >=0 && j1 <= c.length-1){
        	if (set)
            c[i1--][j1++]++; 
        	else c[i1--][j1++]--; 
        }
        
        i1 = i; j1 = j+1;
         while(i1 >= 0 && i1 <= c.length-1 && j1 >=0 && j1 <= c.length-1){
        	 if(set)
            c[i1][j1++]++;
        	 else c[i1][j1++]--; 
        }
        
    }
    
    public void solve(char[][] c, int columnIndex, ArrayList<String[]> result){
        for(int i = 0; i < c.length; i++){
            if(c[i][columnIndex]=='.'){
                if(columnIndex== c.length-1){
                	//c[i][columnIndex]='Q';
                    //print(c, result);
                	this.count++;
                    //c[i][columnIndex]='.';
                    return;
                }
                else{
                    mark(c,i,columnIndex);
                    // recursively call the solve for the next column
                    solve(c, columnIndex+1, result);
                    unmark(c,i,columnIndex);   
                }
            }
        }
    }

	private void print(char[][] c, ArrayList<String[]> result) {
		String[] s = new String[c.length];
		
		for(int i = 0; i < c.length; i++){
			s[i] = "";
			for(int j = 0; j < c.length; j++){
				if(c[i][j]=='Q'){
						s[i]+="Q";
				}
				else{
					s[i]+=".";
				}
			}
		}
		result.add(s);
	}
}
