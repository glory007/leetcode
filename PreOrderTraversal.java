import java.util.HashSet;

// given preorder (root-> left ->right) traversal , print out all possible in order (left ->root -> right) traversal.


public class PreOrderTraversal {
	
	public static void main(String[] args){
		int[] a = {1,2,3};
		for(String x : print(a,0,a.length-1)){
			System.out.println(x);
			
		}
	}
	
	public static HashSet<String> print(int[] a, int s, int e){
		HashSet<String> set = new HashSet<String>();
		if(s>e){
			set.add("");
			return set;
		}
		
		if (s==e){
			set.add(Integer.toString(a[s]));
			return set;
		}
		
		String root = Integer.toString(a[s]);
		
		// no left subtree 
		HashSet<String> right_tree = print(a,s+1,e);
		for(String x : right_tree){
			set.add( root + "," + x);
		}
		
		for(int i = s+1; i<=e; i++){
			HashSet<String> left = print(a,s+1,i);
			HashSet<String> right = print(a,i+1,e);
			
			for(String m : left){
				for(String n:right){
					String tmp = n.equals("") ?  (m + "," + root): (m + "," + root + ","  + n);
					set.add( tmp);
				}
			}
		}
		return set;
	}
}
