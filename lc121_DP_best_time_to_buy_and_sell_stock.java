class Solution {
    public int maxProfit(int[] prices) {
        return solution2(prices);
    }
    
    private int solution2(int[] prices) {
        int deepValue = 65535;
        int deepIdx = -1;
        int peakValue = -1;
        int peakIdx = -1;
        int bestProfitYet = 0;
        for (int i=0; i < prices.length; i++) {
            int x = prices[i];
            if (x < deepValue) {
                deepValue = x;
                deepIdx = i;
                peakValue = -1;
                peakIdx = -1;
            }
            if (x > peakValue) {
                peakValue = x;
                peakIdx = i;
            }
  
            if( peakIdx > deepIdx) {
                int profit = peakValue - deepValue;
                if (profit > bestProfitYet) 
                    bestProfitYet = profit;
            }
        }
        
        return bestProfitYet;
    }
    
    private int solution1(int[] prices) {
        int bestPriceYet = 0;
        int lastProfitablePurchaseAmount = 65535;
        for (int i=0; i< prices.length; i++) {
            if (prices[i] >= lastProfitablePurchaseAmount) {
                continue;
            }
            lastProfitablePurchaseAmount = prices[i];
            for (int j = i+1; j< prices.length; j++) {
                int x = prices[j] - prices[i] ;
                if (x > bestPriceYet) {
                    bestPriceYet = x;
                }
            }
        }
        return bestPriceYet;
    }
}
