# Given a positive integer num, write a function which returns True if num is a perfect square else False.

# Follow up: Do not use any built-in library function such as sqrt.

# Example 1:

# Input: num = 16
# Output: true
# Example 2:

# Input: num = 14
# Output: false
 

# Constraints:

# 1 <= num <= 2^31 - 1

class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        if num == 0 or num == 1:
            return True
        
        low = 0
        high = round(num / 2)
        
        while low <= high:
            mid = round((high + low) / 2)
            res = mid * mid
            
            if res < num:
                low = mid + 1
            elif res > num:
                high = mid - 1
            elif res == num:
                return True
            
        return False
