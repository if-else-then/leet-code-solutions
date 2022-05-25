class Solution {
    public int[] topKFrequent(int[] nums, int k1) {
        int [] topK = new int[k1];
        Map<Integer,Integer> ocIndx = new HashMap<>();
        
        for(int n : nums) {
            if (ocIndx.containsKey(n)) {
                ocIndx.put(n, ocIndx.get(n)+1);
                continue;
            }
            ocIndx.put(n,1);
        }
        
        int max = topK[0];
        int maxI = 0;
        for (int i=0; i< topK.length; ++i) {
            for (int k: ocIndx.keySet()) {
                if (max < ocIndx.get(k)) {
                    max = ocIndx.get(k);
                    maxI = k;
                }
            }
            topK[i] = maxI;
            ocIndx.remove(maxI);
            maxI = 0;
            max = 0;
        }
        return topK;
    }
}

/*
Runtime: 164 ms, faster than 5.24% of Java online submissions for Top K Frequent Elements.
Memory Usage: 64.4 MB, less than 5.43% of Java online submissions for Top K Frequent Elements.
*/
