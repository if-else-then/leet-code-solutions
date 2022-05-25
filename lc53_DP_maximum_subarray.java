class Solution {
    private boolean debug = !false;
    private Map<Integer, Integer> book = new HashMap<>();
    
    public int maxSubArray(int[] nums) {
        // return n_square_solution(nums);
        return kadens_theorem_sol(nums);
    }
    
    private int kadens_theorem_sol(int[] nums) {
        int curSum = nums[0];
        int maxSum = curSum;
        for (int i = 1; i< nums.length; ++i) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
            }
        return maxSum;
    }
    
    private int n_square_solution(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i< nums.length; i++) {
            int tempSum = 0;
            for (int j = i+1; j< nums.length;) {
                tempSum += nums[j++];
                maxSum = Math.max(maxSum, tempSum);
            }
        }
        return maxSum;
    }
}
