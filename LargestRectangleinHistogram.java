// PASSED! both small and large cases.

import java.util.Stack;

public class LargestRectangleinHistogram {

	public static void main(String[] args){
		int[] h = new int[]{2,1,5,6,2,3};
		System.out.println(largestRectangleArea(h));
	}
	
	// http://tianrunhe.wordpress.com/2012/07/26/largest-rectangle-in-histogram/
	// worst case runtime: still O(N^2), but passed large cases since average run time is less than O(N^2);
	public static int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        while(i < height.length) {
            if(stack.isEmpty() || height[i] >= stack.peek()) {
                stack.push(height[i]);
                i++;
            }
            else {
                int count = 0;
                while(!stack.isEmpty() && stack.peek() > height[i]) {
                    count++;
                    int top = stack.pop();
                    max = Math.max(max, top * count);
                }
                for(int j = 0; j < count + 1; ++j) {
                    stack.push(height[i]);
                }
                i++;
            }
        }
        
        int count = 0;
        while(!stack.isEmpty()) {
            count++;
            max = Math.max(max, stack.pop() * count);
        }
        return max;
    }
	

	// first try: naive way O(n^2)
	// SMALL CASE PASSED! LARGE CASE TIME OUT.
    public  static int largestRectangleArea2(int[] height) {
    	
    	if (height.length == 0) return 0;
    	
    	int cur = Integer.MIN_VALUE;
    	
    	for(int s = 0; s <= height.length-1; s++){
    		int cur_height_min = 0;
    		for(int e = s; e<= height.length-1; e++){
    			if(e==s){
    				cur_height_min = height[e];
    			}
    			else{
    				cur_height_min = cur_height_min < height[e] ? cur_height_min : height[e];
    			}
    			
    			int tmp = (e-s+1)*cur_height_min;
    			cur = tmp > cur ? tmp : cur;
    		}
    	}
    	
    	return cur;
    }

}
