class Solution {
    Map<Integer, Integer> stepCount = new HashMap<>();
    public int climbStairs(int n) {
        // depending on how many steps can be taken
        int x = 0;
        int y = 0;
        if (n > 1) {
            if (stepCount.containsKey(n-1)) {
                x = stepCount.get(n-1);
            }
            else {
                x = climbStairs(n-1);
                stepCount.put(n-1,x);
            }
            if(stepCount.containsKey(n-2)) {
                y = stepCount.get(n-2);
            } else {
                y = climbStairs(n-2);
                stepCount.put(n-2, y);
            }
            return x + y;
        }
        else
            return 1;
    }
}
