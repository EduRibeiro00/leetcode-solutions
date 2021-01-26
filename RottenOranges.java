class Solution {
    public int orangesRotting(int[][] grid) {
        Set<String> fresh = new HashSet<>();
        Set<String> rotten = new HashSet<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    fresh.add("" + i + j);
                else if (grid[i][j] == 2)
                    rotten.add("" + i + j);
            }
        }
        
        int minutes = 0;
        
        int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        
        while (fresh.size() > 0) {
            Set<String> infected = new HashSet<>();
            for (String s : rotten) {
                int i = s.charAt(0) - '0';
                int j = s.charAt(1) - '0';
                
                for (int[] direction : directions) {
                    int new_i = i + direction[0];
                    int new_j = j + direction[1];
                    
                    if (fresh.contains("" + new_i + new_j)) {
                        grid[new_i][new_j] = 2;
                        fresh.remove("" + new_i + new_j);
                        infected.add("" + new_i + new_j);
                    }
                }
            }
            
            if (infected.size() == 0)
                return -1;
            
            rotten = infected;
            minutes++;
        }
        
        return minutes;
    }
}