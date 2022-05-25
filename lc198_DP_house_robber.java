class Solution {
    private boolean isDebug= false;
    private Map<Integer, Integer>accountBook = new HashMap<>();
    
    public int rob(int[] nums) {
        int robbedTillNow = 0;
        int currentHouseIdx = 0;
        return rob(robbedTillNow, currentHouseIdx, nums);
    }
    
    private int rob(int robbedTillNow, int startIdx, int[] nums) {
        if(isDebug)System.out.printf("Robbed till now= %d, starting idx = %d\n", robbedTillNow, startIdx);
        // don't go beyond limit
        if (startIdx >= nums.length) return 0;
        
        // start point loot
        int startIdxAmnt = nums[startIdx];
        if(isDebug)System.out.printf("startIdxAmnt = %d\n", startIdxAmnt);
        
        // if there is no next house then beware
        if (startIdx + 1 >= nums.length) {
             if(isDebug)System.out.printf("end of street returning loot = %d\n", startIdxAmnt );
            return startIdxAmnt;
        }
        
        // startPointNxt loot
        int startIdxNxtAmnt = nums[startIdx+1];
        if(isDebug)System.out.printf("startIdxNxtAmnt = %d\n", startIdxNxtAmnt);
        
        // loot logic
        // where I started + next loot amount
        // I can loot in only two ways
        
        if(!accountBook.containsKey(startIdx+2)) {
            int lootNxt = rob(startIdxAmnt, startIdx +2, nums);
            accountBook.put(startIdx+2, lootNxt);
        }
        int lootA = startIdxAmnt + accountBook.get(startIdx+2);
        
        if(!accountBook.containsKey(startIdx+3)) {
            int lootNxt = rob(startIdxNxtAmnt, startIdx +3, nums);
            accountBook.put(startIdx+3, lootNxt);
        }
        int lootB = startIdxNxtAmnt + accountBook.get(startIdx+3);
        
        if(isDebug)System.out.printf("loota = %d, lootb = %d\n", lootA, lootB);
        // starting in one of two way atleast 1 will be better
        if (lootA > lootB) {
            if(isDebug)System.out.printf("returning loot = %d", robbedTillNow + lootA );
            return lootA;
        }
        
        if(isDebug)System.out.printf("returning loot = %d", robbedTillNow + lootB );
        return lootB;
    }
}
