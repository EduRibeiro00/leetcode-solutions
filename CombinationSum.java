class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationAux(res, candidates, target, 0, 0, new ArrayList<Integer>());
        return res;
    }
    
    public void combinationAux(List<List<Integer>> res, int[] candidates, int target, int index, int curSum, List<Integer> curList) {
        if (curSum == target) {
            res.add(curList);
            return;
        }
        if (curSum > target || index == candidates.length) {
            return;
        }
        
        // option 1: add number at current index
        List<Integer> newCurList = new ArrayList<>(curList);
        newCurList.add(candidates[index]);
        int newCurSum = curSum + candidates[index];
        combinationAux(res, candidates, target, index, newCurSum, newCurList);
        
        // option 2: continue to the element in the next index
        combinationAux(res, candidates, target, index + 1, curSum, curList);
    }
}