// Implement atoi which converts a string to an integer.

// The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

// The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

// If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

// If no valid conversion could be performed, a zero value is returned.

// Note:

// Only the space character ' ' is considered a whitespace character.
// Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.



class Solution {
    public int myAtoi(String s) {
        long ret = 0;
        int sign = 1;
        boolean start = false;
        
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            
            // ignore whitespace in the beginning
            if (c == ' ' && !start)
                continue;
            
            // extract sign if the number hasn't been extracted yet
            if (c == '+' && !start) {
                sign = 1;
                start = true;
            }
            else if (c == '-' && !start) {
                sign = -1;
                start = true;
            }
            
            // if it is a number, add it to the number that we already have
            else if (Character.isDigit(c)) {
                if (!start) start = true;
                int code = c - '0';
                ret = (ret * 10) + code;
                
                // overflow!
                if (ret > Integer.MAX_VALUE) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
            
            // in any other case, we finish the cycle
            else {
                break;
            }
            
        }
        
        ret *= sign;
        return (int) ret;
    }
}