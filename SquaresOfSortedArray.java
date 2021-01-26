class Solution {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        
        Arrays.sort(A);
        
        return A;
    }
}


// ------------
// better solution
class Solution {
    public int[] sortedSquares(int[] A) {
        int i = 0;
        int j = A.length - 1;
        int[] res = new int[A.length];
        int pos = A.length - 1;
            
        while (i <= j) {
            
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                res[pos--] = A[i] * A[i];
                i++;
            }
            else {
                res[pos--] = A[j] * A[j];
                j--;
            }
        }
        
        return res;
    }
}