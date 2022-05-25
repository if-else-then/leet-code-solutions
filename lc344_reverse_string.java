class Solution {
    public void reverseString(char[] s) {
        final int len = s.length-1;
        final int mid  = len/2;
        
        char t;
        for (int i=0; i<=mid; i++){
            t = s[len-i];
            s[len-i] = s[i];
            s[i] = t;
        }
        
    }
}
