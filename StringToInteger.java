class Solution {
    public int myAtoi(String str) {
        int i = 0;
        int sign = 1;
        int result = 0;
        if (str.length() == 0) return 0;

        //Discard whitespaces in the beginning
        while (i < str.length() && str.charAt(i) == ' ')
            i++;

        // Check if optional sign if it exists
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            sign = (str.charAt(i++) == '-') ? -1 : 1;

        // Build the result and check for overflow/underflow condition
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(i++) - '0');
        }
        return result * sign;

    }
}

// **********************
// Another solution
// **********************

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