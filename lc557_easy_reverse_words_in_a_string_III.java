class Solution {
    public String reverseWords(String s) {
        char[] input = s.toCharArray();
        int i = 0, j = 0;
        int n = s.length();
        
        while (i < n && j < n) {
            while (i < n && input[i] == ' ') {
                i++;
            }
            j=i;
            while (j < n && input[j]!= ' ') {
                j++;
            }
            reverse (input, i, j-1);
            i = j;
        }
        return new String(input);

    }
    
    private void reverse(char[] chs, int s, int t) {
        while (s < t) {
            char tmp = chs[s];
            chs[s] = chs[t];
            chs[t] = tmp;
            s++;
            t--;
        }
    }
}
