import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String[] daysArray = sc.nextLine().split(" ");
        ArrayList<Integer> meetingDays = new ArrayList<>();
        for (String day : daysArray)
            meetingDays.add(Integer.parseInt(day));
        
        int price1 = sc.nextInt();
        int price3 = sc.nextInt();
        int price7 = sc.nextInt();
        
        int NUM_DAYS = 31;
        
        int[] aux = new int[NUM_DAYS + 1];
        aux[0] = 0;
        
        for (int i = 1; i <= NUM_DAYS; i++) {
            aux[i] = aux[i-1] + price1;
            
            if (i >= 3) {
                aux[i] = Math.min(aux[i], aux[i-3] + price3);
            }
            
            if (i >= 7) {
                aux[i] = Math.min(aux[i], aux[i-7] + price7);
            }
            
            if (!meetingDays.contains(i)) {
                aux[i] = Math.min(aux[i-1], aux[i]);
            }
        }
        
        System.out.println(aux[NUM_DAYS]);
    }
}
