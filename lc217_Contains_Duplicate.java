class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> isDup = new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            if (isDup.containsKey(nums[i])) return true;
            isDup.put(nums[i], i);
        }
        return false;
    }
}
/*
20 / 20 test cases passed.
Status: Accepted
Runtime: 6 ms
Memory Usage: 45.3 MB
*/
