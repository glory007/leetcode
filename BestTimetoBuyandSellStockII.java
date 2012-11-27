// SOLVED! both small and large cases
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length<=1) return 0;
        int profit = 0;
        
        int curr_low = prices[0];
       
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > curr_low){
                profit += (prices[i]-curr_low);
               
            }
            curr_low = prices[i];
        } 
        return profit;
    }
}
