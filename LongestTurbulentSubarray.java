// Sliding window, O(n)
class Solution {
    public int maxTurbulenceSize(int[] A) {
        int N = A.length;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < N; ++i) {
            int c = Integer.compare(A[i-1], A[i]);
            if (c == 0) {
                anchor = i;
            } else if (i == N-1 || c * Integer.compare(A[i], A[i+1]) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }

        return ans;
    }
}

// *************************
// Another solution
// *************************

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr == null || arr.length < 1) return 0;
 
        int max_len = 1;
        int cur_len = 1;
        boolean higher = false;
        boolean reset = true;
        
        for (int i = 1; i < arr.length; i++) {
            if (reset) {
                if (arr[i-1] == arr[i]) {
                    continue;
                }

                higher = arr[i-1] < arr[i];
                max_len = Math.max(max_len, ++cur_len);
                reset = false;
            }
            else {
                if ((higher && arr[i-1] > arr[i]) ||
                    (!higher && arr[i-1] < arr[i])) {
                    max_len = Math.max(max_len, ++cur_len);
                    higher = !higher;
                }
                else {
                    if (arr[i-1] == arr[i]) {
                        cur_len = 1;
                        reset = true;
                    }
                    else {
                        higher = arr[i-1] < arr[i];
                        cur_len = 1;
                        max_len = Math.max(max_len, ++cur_len);
                    }
                }   
            }
        }
        
        
        return max_len;
    }
}