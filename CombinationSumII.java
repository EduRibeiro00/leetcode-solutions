class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    int tar;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        nums = candidates;
        tar = target;
        Arrays.sort(nums);
        combinationAux(new ArrayList<Integer>(), 0, 0);
        return res;
    }
    
    private void combinationAux(List<Integer> arr, int curIdx, int curSum) {
        if (curSum > tar) return;
        if (curSum == tar) {
            res.add(new ArrayList<>(arr));
            return;
        }
        
        for (int i = curIdx; i < nums.length; i++) {
            if (curIdx < i && nums[i] == nums[i - 1]) continue;
            arr.add(nums[i]);
            combinationAux(arr, i + 1, curSum + nums[i]);
            arr.remove(arr.size() - 1);
        }
    }
}