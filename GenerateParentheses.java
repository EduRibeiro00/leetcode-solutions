class Solution {
    List<String> res = new ArrayList<>();
    int finalLen;
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return new ArrayList<>(Arrays.asList(""));
        
        finalLen = 2*n;
        backtrack("", 0, 0, n);
        return res;   
    }
    
    public void backtrack(String curStr, int open, int close, int max) {
        if (curStr.length() == finalLen) {
            res.add(curStr);
            return;
        }
        
        if (open < max)
            backtrack(curStr + "(", open + 1, close, max);
        if (open > close)
            backtrack(curStr + ")", open, close + 1, max);
    }
}