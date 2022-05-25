class Solution {
    public void moveZeroes(int[] nums) {
        int ptrI=-1, ptrJ=1, zC = 0;
        for (int i=0; i<nums.length; i++)
        {
            if (nums[i]==0) ++zC;
        }
        if(zC == 0) return;
        
        for (int i=0; i<nums.length; i++)
        {
            if(nums[i] != 0)
            {
                nums[++ptrI] = nums[i];
            }
        }
        for (int i = ptrI+1; i<nums.length; i++)
        {
            if(nums[i]!=0)
            {
                nums[i] = 0;
            }
        }
        
    }
}
