class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
        }
    
        for (int i = dp.length - 2; i >= 0; i--) {
            int maxJump = i + nums[i] < dp.length ?
                i + nums[i] : dp.length - 1;
            for (int j = i + 1; j <= maxJump; j++) {
                if (j < dp.length - 1 && dp[j] == 0) continue;
                    
                // not initialized
                if (dp[i] == 0 || dp[i] > dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        return dp[0];
    }
}