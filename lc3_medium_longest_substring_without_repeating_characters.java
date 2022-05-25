public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
            //System.out.printf("i is %d, j = %d, cache[%c] = %d, result is %d\n", i, j, s.charAt(i), cache[s.charAt(i)], result);
        }
        return result;
    }
}
