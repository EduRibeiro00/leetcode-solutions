class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, arr[start]});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]] = true;
            
            if (cur[1] == 0) return true;
            int iLeft = cur[0] - arr[cur[0]];
            int iRight = cur[0] + arr[cur[0]];
            
            if (iLeft >= 0 && !visited[iLeft]) {
                q.offer(new int[]{iLeft, arr[iLeft]});
            }
            if (iRight < arr.length && !visited[iRight]) {
                q.offer(new int[]{iRight, arr[iRight]});
            }
        }
        return false;
    }
}