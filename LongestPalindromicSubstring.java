class Solution {
    public String longestPalindrome(String s) {
        String max_st = "";
        
        for (int i = 0; i < s.length(); i++) {
            String st1 = this.checkForPalindrome(s, i, i);
            String st2 = this.checkForPalindrome(s, i, i+1);
            String st = st1;
            if (st2.length() > st1.length()) {
                st = st2;
            }
            if (st.length() > max_st.length()) {
                max_st = st;
            }
        }
        
        return max_st;
    }
    
    public String checkForPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}