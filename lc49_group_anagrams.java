class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return solution1(strs);
        /*
        Runtime: 1753 ms, faster than 5.03% of Java online submissions for Group Anagrams.
        Memory Usage: 178.3 MB, less than 5.00% of Java online submissions for Group Anagrams.
        */
    }
    
    private List<List<String>> solution1(Strings[] strs) {
        List<List<String>> anagrams = null;
        for (var str: strs) {
            if (anagrams == null) {
                anagrams = new ArrayList<>();
                anagrams.add(createANewListForAnagramsWithString(str));
                continue;
            }
            boolean strAdded = false;
            for (var lst: anagrams) {
                if(isAnagram(str, lst.get(0))) {
                    lst.add(str);
                    strAdded = true;
                    break;
                }
            }
            if(!strAdded) {
                anagrams.add(createANewListForAnagramsWithString(str));
                strAdded = false;
            }
        }
        return anagrams;
    }
        
    private List<String> createANewListForAnagramsWithString(String x) {
        var l = new ArrayList<String>();
        l.add(x);
        return l;
    }
        
    private boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
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
