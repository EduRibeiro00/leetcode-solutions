// My solution
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteAux(res, nums, new HashSet<>(), new ArrayList<>());
        return res;
    }
    
    public void permuteAux(List<List<Integer>> res, int[] nums, Set<Integer> used, List<Integer> curArr) {
        if (curArr.size() == nums.length) {
            res.add(new ArrayList<>(curArr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used.contains(nums[i])) continue;
            used.add(nums[i]);
            curArr.add(nums[i]);
            permuteAux(res, nums, used, curArr);
            curArr.remove(curArr.size() - 1);
            used.remove(nums[i]);
        }
    }
}

// Another solution that swaps elements in the list
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> str = new ArrayList<>();
        permute(nums, 0, nums.length-1, arr, str);
        
        return arr;
    }
    
    private void permute(int[] nums, int l, int r,List<List<Integer>> arr, List<Integer> a2) {
        if(l==r) {
            a2.add(nums[l]);
            arr.add(new ArrayList<>(a2));
            a2.remove(new Integer(nums[l]));
        } else {
             for(int i =l;i<=r;i++) {
                swap(nums, l, i);
                a2.add(nums[l]);
                permute(nums, l+1, r, arr, a2);
                a2.remove(new Integer(nums[l]));
                swap(nums, l, i);
            }
        
        }
      
    }
    
    
    private void swap(int[] nums, int i, int j) {
        if(i==j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}