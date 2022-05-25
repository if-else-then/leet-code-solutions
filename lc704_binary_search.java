class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int start =0;
        int end = nums.length-1;
        int mid = 0;
        if (start == mid && nums[mid] == target) return mid;
        while (start <= end) {
            mid = start + (end-start) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
