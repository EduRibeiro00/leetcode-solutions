class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> response = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 1; i++) {
            // avoid duplicates
            if (i != 0 && nums[i] == nums[i-1])
                continue;
        
            int target = 0 - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
        
            while(start < end) {
                if (nums[start] + nums[end] == target) {
                    response.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start] == nums[start+1]) start++;
                    while (start < end && nums[end] == nums[end-1]) end--;
                    start++;
                    end--;
                }
                else if (nums[start] + nums[end] > target) {
                    end--;
                }
                else {
                    start++;
                }
            }
        }
        
        return response;
    }
}