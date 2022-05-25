class Solution {
    private int[] cost;
    private Map<Integer, Integer> memo = new HashMap<>();
    
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        return dp(cost.length);
    }
    
    private int dp(int length) {
        if (length < 2) return 0;
            
        if (!memo.containsKey(length)) {
            memo.put(length, Math.min(cost[length-1] + dp(length-1),cost[length-2] + dp(length-2)));
        }
        return memo.get(length);
    }
}
