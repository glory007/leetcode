// SOLVED! both small and large cases!

// Remove Element
// Given an array and a value, remove all instances of that value in place and return the new length.
// 
// The order of elements can be changed. It doesn't matter what you leave beyond the new length.
// // 

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if(A.length==0) return 0;
        int s = 0;
        int e = A.length-1;
        
        while(s<e){
            if(A[s]!=elem && A[e] == elem){
                s++;e--;
            }
            else if(A[s]!=elem && A[e]!=elem){
                s++;
            }
            else if (A[s]== elem && A[e] == elem){
                e--;
            }
            else {
                int tmp = A[s];
                A[s] = A[e];
                A[e] = tmp;
                
            }
        }
     
        
    
    
    if(A[s] == elem){
        return s;
    }
    else{
        return s+1;
    }
}}