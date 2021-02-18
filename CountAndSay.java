class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            System.out.println(i + " - " + res);
            res = getNewString(res);
        }
        return res;
    }
    
    public String getNewString(String str) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            cnt++;
            if (i == str.length() - 1 || c != str.charAt(i+1)) {
                sb.append("" + cnt + c);
                cnt = 0;
            }
        }
        return sb.toString();
    }
}