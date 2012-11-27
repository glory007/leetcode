import java.util.ArrayList;

// SOLVED! both small and large cases. 

// RUN TIME: O(N^2), any better ways?

/*
 * Container With Most Water
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container.
 */
public class ContainerWithMostWater {

	static class Pair{
		int v1;
		int v2;
		Pair(int v1, int v2){
			this.v1 = v1;
			this.v2 = v2;
		}
	}
	
	public static void main(String[] args){
		int [] h = new int[]{3,2,4,5,3,6};
		System.out.println(maxArea(h));
	}
	
	public static int maxArea(int[] height) {
		
		if(height.length <= 1) return 0;
		
		ArrayList<Pair> a1 = new ArrayList<Pair>();
		a1.add(new Pair(0, height[0]));
		
		ArrayList<Pair> a2 = new ArrayList<Pair>();
		a2.add(new Pair(height.length-1, height[height.length-1]));
		
		// first calc the right endpoint candidates
		for(int i = 1; i < height.length - 1; i++){
			if(height[i] > a1.get(a1.size()-1).v2){
				a1.add(new Pair(i, height[i]));
			}
		}
        
		//  calc the left endpoint candidates
		for(int i = height.length-2; i > 0; i--){
			if(height[i] > a2.get(a2.size()-1).v2){
				a2.add(new Pair(i, height[i]));
				System.out.println(i+","+ height[i]);
			}
		}
		
		int r = Integer.MIN_VALUE;
		for(int i = 0; i < a1.size(); i++){
			for(int j = 0; j < a2.size(); j++){
				
				if(a2.get(j).v1 <= a1.get(i).v1){
					continue;
				}
				int tmp = (a2.get(j).v1- a1.get(i).v1) * (a2.get(j).v2 > a1.get(i).v2 ? a1.get(i).v2 : a2.get(j).v2 );
				r = tmp > r ? tmp:r;
			}
		}
		return r;
    }
}
