public static long maxValue(int n, List<List<Integer>> rounds) {
    // Write your code here
    if (rounds.isEmpty()) return 0;
    long[] array = new long[n + 1];
    for (List<Integer> round : rounds) {
        array[round.get(0)] += round.get(2);
        if (round.get(1) < array.length - 1)
            array[round.get(1) + 1] -= round.get(2); 
    }
    long max_value = 0;
    long cur_value = 0;
    for (long value : array) {
        cur_value += value;
        max_value = Math.max(max_value, cur_value);
    }
    
    return max_value;
}