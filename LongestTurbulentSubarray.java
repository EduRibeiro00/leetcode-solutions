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