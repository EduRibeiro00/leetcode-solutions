// Kadanes algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        
        int max_sum = nums[0];
        int cur_sum = max_sum;
        for (int i = 1; i < nums.length; i++) {
            int new_sum = nums[i];
            cur_sum = Math.max(new_sum, new_sum + cur_sum);
            max_sum = Math.max(max_sum, cur_sum);
        }
        return max_sum;
    }
}