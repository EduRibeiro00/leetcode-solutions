class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int tar;
    int size;
    public List<List<Integer>> combinationSum3(int k, int n) {
        size = k;
        tar = n;
        combinationAux(new ArrayList<>(), 0, 1);
        return res;
    }
    
    public void combinationAux(List<Integer> arr, int curSum, int curNum) {
        if (curSum > tar || arr.size() > size) return;
        if (curSum == tar && arr.size() == size) {
            res.add(new ArrayList<>(arr));
            return;
        }
        
        for (int i = curNum; i <= 9; i++) {
            arr.add(i);
            combinationAux(arr, curSum + i, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}