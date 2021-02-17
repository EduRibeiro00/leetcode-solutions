class Solution {
    public boolean isValidSudoku(char[][] board) {
        return checkLines(board) && checkColumns(board)
            && checkSquares(board);
    }
    
    public boolean checkLines(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> hs = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (hs.contains(board[i][j]))
                    return false;
                if (board[i][j] != '.') {
                    hs.add(board[i][j]);
                }
            }
        }
        return true;
    }
    
    public boolean checkColumns(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> hs = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (hs.contains(board[j][i]))
                    return false;
                if (board[j][i] != '.') {
                    hs.add(board[j][i]);
                }
            }
        }
        return true;
    }
    
    public boolean checkSquares(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkIndividualSquare(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkIndividualSquare(char[][] board, int startI, int startJ) {
        Set<Character> hs = new HashSet<>();
        for (int i = startI; i < startI + 3; i++) {
            for (int j = startJ; j < startJ + 3; j++) {
                if (hs.contains(board[i][j]))
                    return false;
                if (board[i][j] != '.') {
                    hs.add(board[i][j]);
                }
            }
        }
        return true;
    }
}