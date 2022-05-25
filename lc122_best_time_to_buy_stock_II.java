class Solution {
    public int maxProfit(int[] prices) {
        // return solutionPeakDeep(prices);
        return solutionAllPositiveDifferences(prices);
    }
    private int solutionAllPositiveDifferences(int[] prices) {
        int profit = 0;
        for(int i=1; i<prices.length; ++i) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
    
    private int solutionPeakDeep(int[] prices) {
        int deep = Integer.MAX_VALUE;
        int peak = deep;
        int profit = 0;
        
        for(int i=0; i< prices.length;) {
            if(prices[i] < peak) {
                profit += (peak-deep);
                peak = deep = prices[i++];
            }
            else if (prices[i] > peak) {
                peak = prices[i];
            }
        }
        profit += peak-deep;
        return profit;
    }
}
