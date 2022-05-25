class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mEnd = m-1;
        int nEnd =  n-1;
        int end = m+n-1;
        while (end >= 0) {
            if(nEnd < 0) break;
            if (mEnd >= 0 && (nums1[mEnd] > nums2[nEnd])) nums1[end] = nums1[mEnd--];
            else nums1[end] = nums2[nEnd--];
            end--;
        }
    }
}
