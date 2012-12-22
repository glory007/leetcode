// PASSED! both small and large cases.

import java.util.Stack;

/*
 * http://www.informatik.uni-ulm.de/acm/Locals/2003/html/judge.html
 * 
 */
public class LargestRectangleinHistogram {

	public static void main(String[] args){
		int[] h = new int[]{5,6,2};
		System.out.println(largestRectangleArea3Helper(h,0,h.length-1));
	}
	

	// small case passed. large case failed.
	// TODO: use RMQ to speed up the minimum query.
	public static int largestRectangleArea3(int[] height){
		return largestRectangleArea3Helper(height, 0, height.length-1);
	}
	
	public static int largestRectangleArea3Helper(int[] height, int s, int e){
		if(s > e) return 0;
		if(s == e) return height[s];
		
		int min = height[s];
		int idx = s;
		for(int i = s+1; i <=e ; i++){
			if(height[i] < min){
				min = height[i];
				idx=i;
			}
		}
		
		int r1;
		int r2;
		int r3 = min * (e-s+1);
		

		if (idx == e){
			r1 = largestRectangleArea3Helper(height, s, idx-1);
			r2 = largestRectangleArea3Helper(height, idx, e);
		}
		else{
			r1 = largestRectangleArea3Helper(height, s, idx);
			r2 = largestRectangleArea3Helper(height, idx+1, e);
		}
		return Math.max(r1, Math.max(r3, r2));
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
