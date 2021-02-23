// O(n) solution
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, idx = 0;
        for (int i = 0; i < gas.length; i++) {
            int consume = (gas[i] - cost[i]);
            tank += consume;
            if (tank < 0) {
                idx = i + 1;
                tank = 0;
            }
            total += consume;
        }
        return total < 0 ? -1 : idx;
    }
}


// O(n^2) solution
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // starting point
        for (int s = 0; s < gas.length; s++) {   
            // try to do the lap
            if(canGiveLap(gas, cost, s))
                return s;
        }
        return -1;
    }
    
    public boolean canGiveLap(int[] gas, int[] cost, int s) {
        if (gas[s] < cost[s]) return false;
        int curGas = gas[s] - cost[s];
        for (int i = 1; i <= gas.length; i++) {
            // calc current position
            int cur = (s + i) % gas.length;
            curGas += (gas[cur] - cost[cur]);
            if (curGas < 0) return false;
        }
        return true;
    }
}