class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char p;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    st.push(c);
                    break;
                case ')':
                    if (st.isEmpty()) return false;
                    p = st.pop();
                    if (p != '(') return false;
                    break;
                case '}':
                    if (st.isEmpty()) return false;
                    p = st.pop();
                    if (p != '{') return false;
                    break;
                case ']':
                    if (st.isEmpty()) return false;
                    p = st.pop();
                    if (p != '[') return false;
                    break;
            }
        }
        return st.isEmpty();
    }
}