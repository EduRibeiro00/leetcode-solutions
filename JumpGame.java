class Solution {
    public boolean canJump(int[] nums) {
        // array that indicates for each position
        // if we are able to reach the last index
        boolean[] able = new boolean[nums.length];
        // last index is true because we're already there
        able[able.length - 1] = true;
        
        for (int i = able.length - 2; i >= 0; i--) {
            int maxJump = nums[i];
            boolean isAble = false;
            for (int j = i + 1; (j <= i + maxJump) && (j < able.length); j++) {
                if (able[j]) {
                    isAble = true;
                    break;
                }
            }
            able[i] = isAble;
        }
        return able[0];
    }
}