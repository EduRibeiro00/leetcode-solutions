class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev1 = 0;
        int prev2 = cost[0];
        for (int i = 1; i < cost.length; i++) {
            int prevMin = Math.min(prev1, prev2);
            prev1 = prev2;
            prev2 = prevMin + cost[i];
        }
        return Math.min(prev1, prev2);
    }
}