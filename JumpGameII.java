// O(n) greedy solution
class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int currend=0;
        int currfarthest=0;
        //nums.length-1 cause we dont need to jump from end index
        for(int i=0;i<nums.length-1;i++){
            // the farthest we can reach from a index
            currfarthest=Math.max(currfarthest,nums[i]+i);
            //if we reach end index before reaching currend we already
			//know that we should have jumped earlier so we will 
			//update currend to farthest(i.e end index or greater) 
			//increment jumps and break 
            if(i==currend){
                // when we reach currentend we need to take another jump
                jumps++;
                currend=currfarthest;
                // break the loop if we already reached end or further
                if(currend>=nums.length-1){
                break;
            }
            }
            
        }
        return jumps;       
    }
}

// O(n^2) DP solution
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
        }
    
        for (int i = dp.length - 2; i >= 0; i--) {
            int maxJump = i + nums[i] < dp.length ?
                i + nums[i] : dp.length - 1;
            for (int j = i + 1; j <= maxJump; j++) {
                if (j < dp.length - 1 && dp[j] == 0) continue;
                    
                // not initialized
                if (dp[i] == 0 || dp[i] > dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        
        return dp[0];
    }
}