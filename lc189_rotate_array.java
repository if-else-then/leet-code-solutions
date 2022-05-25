class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length < 2) return;
        if (k > nums.length) 
        {
            k %= nums.length;
        }
        //stage-1
        reverse(nums, nums.length-k, nums.length-1);
        print(nums);
        //stage-2
        reverse(nums, 0 , nums.length-k-1);
        print(nums);
        //stage-3
        reverse(nums, 0, nums.length-1);
        print(nums);
    }
    public void reverse(int[] nums, int start, int end)
    {
        int p1 = start;
        int p2 = end;
        if (end < start || end == start) return;
        while (p1 < p2)
        {
            nums[p1] = nums[p1] ^ nums[p2];
            nums[p2] = nums[p1] ^ nums[p2];
            nums[p1] = nums[p1] ^ nums[p2];
            --p2;
            ++p1;
        }
    }
    private void print(int[] nums) {
        for (int i =0; i<nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("========");
    }
}
