// O(log n) solution - divide and conquer to find maximum.
// Could've also done binary search.
class Solution {
    public int findPeakElement(int[] nums) {
        return findPeakAux (nums, 0, nums.length - 1);
    }
    
    public int findPeakAux(int[] nums, int start, int end) {
        if (start == end) return start;
        if (start + 1 == end) return nums[start] > nums[end] ? start : end;
        int mid = start + (end - start) / 2;
        int leftIdx = findPeakAux(nums, start, mid);
        int rightIdx = findPeakAux(nums, mid + 1, end);
        return nums[leftIdx] < nums[rightIdx] ? rightIdx : leftIdx;
    }
}