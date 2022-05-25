class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        
        answer[0]=1;
        for (int i = 1; i< nums.length; ++i) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        int product = 1;
        for (int i=nums.length-1; i>=0; i--) {
            answer[i] *= product;
            product *= nums[i];
        }
        return answer;
    }
}
/*
Runtime: 3 ms, faster than 40.92% of Java online submissions for Product of Array Except Self.
Memory Usage: 58 MB, less than 30.48% of Java online submissions for Product of Array Except Self
*/
