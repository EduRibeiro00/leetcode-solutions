class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int elem: nums) {
                if (i >= elem) {
                    dp[i] += dp[i-elem];
                }
            }
        }
        return dp[target];
    }
}