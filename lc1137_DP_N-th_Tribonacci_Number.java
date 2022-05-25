class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    private int[] dp = new int[38];
    
    public int tribonacci(int n) {
        return tribonacci_dp(n);
        // return tribonacci_memo(n);
    }
    
    public int tribonacci_memo(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            default:
                if (!memo.containsKey(n)) {
                    memo.put(n, tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3));
                }
                return memo.get(n);
        }
    }
    
    public int tribonacci_dp(int n) {
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        
        if (n<3) {
            return  dp[n];
        }
        
        for (int i=3; i<=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
/*
39 / 39 test cases passed.
Status: Accepted
Runtime: 0 ms
Memory Usage: 40.9 MB
*/
