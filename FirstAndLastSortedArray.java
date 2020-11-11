class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = this.binarySearchStart(nums, target);
        int end = this.binarySearchEnd(nums, target);
        return new int[]{start, end};
    }
    
    public int binarySearchStart(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target)
                high = mid - 1;
            else
                low = mid + 1;
            
            if (nums[mid] == target) index = mid;
        }
        
        return index;
    }
    
    public int binarySearchEnd(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target)
                low = mid + 1;
            else
                high = mid - 1;
            
            if (nums[mid] == target) index = mid;
        }
        
        return index;
    }
}