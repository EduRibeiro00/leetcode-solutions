class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) return 0;
        
        int i = 0;
        int j = 0;
        int max_len = 0;
        HashSet<Character> current_chars = new HashSet<>();
        
        while (j < s.length()) {
            while(i < j && current_chars.contains(s.charAt(j))) {
                current_chars.remove(s.charAt(i++));
            }
            
            current_chars.add(s.charAt(j));
            int cur_len = j - i + 1;
            if (cur_len > max_len) {
                max_len = cur_len;
            }
            
            j++;
        }
        
        return max_len;
    }
}