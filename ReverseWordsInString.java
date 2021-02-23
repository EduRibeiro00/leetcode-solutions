// easy solution I guess
class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split(" +");
        Collections.reverse(Arrays.asList(arr));
        return String.join(" ", arr);
    }
} 


// need to get rid of spaces in mid
// 1) reverse every word
// 2) reverse whole string
class Solution {
    public String reverseWords(String s) {
        char [] arr = s.toCharArray();
        int cur = ignoreSpaces(arr, 0);
        int wordStart = cur;
        while (cur < arr.length) {
            if (arr[cur] != ' ') {
                cur++;
            }
            else {
                reverse(arr, wordStart, cur-1);
                cur = ignoreSpaces(arr, cur);
                wordStart = cur;
            }
        }
        // reverse last word
        reverse(arr, wordStart, cur-1);
        reverse(arr, 0, arr.length - 1);
        return new String(arr);
    }
    
    public int ignoreSpaces(char[] arr, int cur) {
        while (cur < arr.length && arr[cur] == ' ') {
            cur++;
        }
        return cur;
    }
    
    public void reverse(char[] arr, int start, int end) {
        while(start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}