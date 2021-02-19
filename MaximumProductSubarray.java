class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int maxPrev = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(maxPrev * nums[i], min * nums[i]));
            result = Math.max(result, max);
        }
        
        return result;
    }
}