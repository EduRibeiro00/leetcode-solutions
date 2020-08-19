# Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

# Examples:

# s = "leetcode"
# return 0.

# s = "loveleetcode"
# return 2.
 

# Note: You may assume the string contains only lowercase English letters.

class Solution:
    def firstUniqChar(self, s: str) -> int:
        for idx in range(len(s)):
            unique = True
            for idx2 in range(len(s)):
                if idx != idx2 and s[idx] == s[idx2]:
                    unique = False
                    break
            if unique:
                return idx
        return -1
            