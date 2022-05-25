class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int[] s1Map = new int[26];
        for (int i=0; i<s1.length(); ++i) {
            s1Map[s1.charAt(i)-'a'] ++;
        }
        
        for (int i=0; i<= s2.length()-s1.length(); ++i) {
            int [] s2Map = new int[26];
            for (int j = 0; j <s1.length(); ++j) {
                s2Map[s2.charAt(i+j)-'a']++;
            }
            if (match(s1Map, s2Map))
                return true;
        }
        return false;
    }
    
    private boolean match(int[] m1, int[] m2) {
        for (int i = 0; i < 26; ++i) {
            if (m1[i] != m2[i]) 
                return false;
        }
        return true;
    }
}
