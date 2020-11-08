class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        
        while (start < end) {
            int currentArea = this.calcArea(start, end, height);
            if (currentArea > maxArea)
                maxArea = currentArea;
            
            if (height[start] < height[end])
                start++;
            else
                end--;
            
        }
        
        return maxArea;
    }
    
    public int calcArea(int start, int end, int[] height) {    
        return ((end - start) * Math.min(height[end], height[start]));
    }
}