// My solution

class Solution {
    int idx;
    public int evalRPN(String[] tokens) {
        idx = tokens.length - 1;
        return parseOperation(tokens);
    }
    
    public int parseOperation(String[] tokens) {
        String s = tokens[idx];
        idx--;
        int first, second;
        switch (s) {
            case "*":
                second = parseOperation(tokens);
                first = parseOperation(tokens);
                return first * second;
                
            case "/":
                second = parseOperation(tokens);
                first = parseOperation(tokens);
                return first / second;
                
            case "+":
                second = parseOperation(tokens);
                first = parseOperation(tokens);
                return first + second;
                
            case "-":
                second = parseOperation(tokens);
                first = parseOperation(tokens);
                return first - second;
                
            // just a number
            default:
                return Integer.parseInt(s);
        }
    }
}

// Clean solution with HashMap and BiFunction (and stack)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack();
        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap();
        map.put("+", Integer::sum);
        map.put("*", (a, b) -> a*b);
        map.put("-", (a,b) -> a-b);
        map.put("/", (a,b) -> a/b);
        for(String s: tokens) {
            if(map.containsKey(s)) {
               int op2 = Integer.valueOf(stack.pop()); 
               int op1 = Integer.valueOf(stack.pop());
               stack.push(map.get(s).apply(op1, op2).toString()); 
            } else {
                stack.push(s);
            }
        }
        
        return Integer.valueOf(stack.pop());
    }
}