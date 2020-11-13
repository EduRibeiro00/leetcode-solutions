class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths_table = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            paths_table[i][n-1] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            paths_table[m-1][i] = 1;
        }
        
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                paths_table[i][j] = paths_table[i+1][j] + paths_table[i][j+1];
            }
        }
        
        return paths_table[0][0];
    }
}