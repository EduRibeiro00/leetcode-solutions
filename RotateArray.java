class Solution {
    public void rotate(int[] nums, int k) {
        int[] aux = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            aux[(i + k) % aux.length] = nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = aux[i];
        }
    }
}