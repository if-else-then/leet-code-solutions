class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> record = new HashMap<>();
        for (int i = 0; i< s.length(); ++i) {
            char c = s.charAt(i);
            if(record.containsKey(c)) {
                record.put(c, record.get(c) + 1);
            } else {
                record.put(c,1);
            }
        }
        for(int i =0; i< t.length(); i++) {
            char c = t.charAt(i);
            if(record.containsKey(c)){
                record.put(c, record.get(c) -1);
                if(record.get(c) == 0) {
                    record.remove(c);
                }
            }
            else
                return false;
        }
        if (record.isEmpty()) {
            return true;
        }
        return false;
        
    }
}
/*
36 / 36 test cases passed.
Status: Accepted
Runtime: 18 ms
Memory Usage: 47 MB
*/
