class Solution {
    public int searchInsert(int[] nums, int target) {
        int left =0, right = nums.length -1, mid = 0;
        // smaller than the smallest case
        if (target < nums[0]) return 0;
        // larger than the largest case
        if (target > nums[nums.length-1]) return nums.length;
        
        // mid case
        while(left <= right) {
            mid = left + (right-left)/2;
            // case where the item is found
            if (nums[mid] == target) return mid;
            
            // all other cases
            if (nums[mid] < target) {
                if(nums[mid+1] >= target) return mid +1;
                left = mid;
            }
            else {
                if (nums[mid-1] < target) return mid;
                right = mid -1;
            }
        }
        return -1;
    }

}
