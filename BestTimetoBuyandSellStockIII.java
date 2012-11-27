// SOLVED! both small and large cases. but after several times of trying and debugs.

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class BestTimetoBuyandSellStockIII {
	
	public static void main(String[] args){
		int[] p = new int[] {2,1,2,0,1};
		System.out.print(maxProfit(p));
	}
	
    public static  int maxProfit(int[] prices) {
        if (prices.length<=1) return 0;
        
        // left side
        int current_low = prices[1] > prices[0] ? prices[0]: prices[1];
        int[] left = new int[prices.length - 1 ];
        int current_max = 0;
        for(int i = 1; i < prices.length; i++){
        	current_max = prices[i] - current_low > current_max ? prices[i] - current_low : current_max;
        	left[i-1] =  current_max;
        	if(prices[i] < current_low){
        		current_low = prices[i];
        	}
        }
        
        // right side
        int  current_high = prices[prices.length - 1] ;
        int[] right = new int[prices.length - 1];
        current_max = 0;
        for(int i = prices.length - 2; i>=0; i--){
        	current_max = current_high - prices[i] > current_max ? current_high - prices[i] : current_max;
        	right[prices.length-2-i] = current_max;
        	if(prices[i] > current_high){
        		current_high = prices[i];
        	}
        }
        
        int max = left[left.length-1];
        
        for(int i = 0; i < left.length -1 ; i++){
        	if(left[i] + right[right.length-2-i] > max)
        	{
        		max = left[i] + right[right.length-2-i];
        	}
        }
        return max;
        
    }

}
