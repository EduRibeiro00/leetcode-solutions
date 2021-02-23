// Recursion with backtracking
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int i, int[] candidates, int target, List<Integer> comb, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] > target) continue;

            comb.add(candidates[j]);
            combinationSum(j, candidates, target - candidates[j], comb, result);
            comb.remove(comb.size() - 1);
        }
    }
}

// Recursion
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