class Solution {
    public int[] sortedSquares(int[] nums) {       
        int length = nums.length-1;
        // this is the simplest case
        if (nums[0] >= 0 ) {
            simpleSquare(nums, 0);
            return nums;
        }
        // otherwise we find the median of the subarray such that the
        // value from on the right is no greater than the absolute value of the left
        else {
            // we know the numbers are sorted, we'll exploit that fact
            // the first number in the array is either positive or
            // the largest negetive number of the input set.
            int left = 0, right = length;
            int maxLeftAbsVal = Math.abs(nums[left]);
            int subArLen = binSearchMinGreaterVal(nums, maxLeftAbsVal);
            int[] newAr = new int[subArLen];
            right = subArLen-1;
            // something like selection square :)
            for(int i = subArLen-1; i>= 0; i--) {
                int l = sq(nums[left]);
                int r = sq(nums[right]);
                if (l > r) {
                    newAr[i] = l;
                    left ++;
                }
                else if (r > l) {
                    newAr[i] = r;
                    right --;
                }
                else {
                    newAr[i] = l;
                    left++;
                    // right--;
                }
            }
            
            for (int i =0; i< newAr.length; i++){
                nums[i] = newAr[i];
            }
            simpleSquare(nums, subArLen);
            
            // 
        }
        return nums;
    }
    
    private int sq(int x) { return x*x;}

    private int binSearchMinGreaterVal(int[] nums, final int target) {
        int left = 0, right = nums.length-1, mid = 0;
        while (left <= right) {
            mid = left + (right -left)/2;
            if (target == nums[mid]) {
                return mid;
            }
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid+1;
            }
        }
        return left;
    }
    
    private void simpleSquare(int[] nums, int index) {
        for (int i=index; i< nums.length; ++i){
            nums[i] *= nums[i];
        }
    }
}
