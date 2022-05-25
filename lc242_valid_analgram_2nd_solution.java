class Solution {
    public boolean isAnagram(String s, String t) {
        char[] alpha = new char[26];
        for (char c: s.toCharArray()) {
            alpha[c-'a']++;
        }
        for (char c:t.toCharArray()) {
            alpha[c-'a']--;
        }
        for (int i = 0; i< alpha.length; i++)
        {
            if(alpha[i] !=0) {
                return false;
            }
        }
        return true;
    }
}
