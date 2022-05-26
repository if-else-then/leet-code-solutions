class Solution {
    private int[] dp;
    public int lengthOfLIS(int[] nums) {
        return dpSolution(nums);
    }
    private int dpSolution(int[] nums) {
        dp = new int[nums.length];
        // base condition
        Arrays.fill(dp,1);
        
        for (int i=0; i< nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }
        int max = 0;
        for (int i: dp) {
            if (i > max) {
                max = i;
            }
        }
        
        return max;
    }
}
