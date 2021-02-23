import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

// My solution using HashSet
public class FirstMissingPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert array separated by spaces:");
        String[] arr = scanner.nextLine().split(" ");
        int[] arrInt = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        smallestNotInSequence(arrInt);
    }

    public static void smallestNotInSequence(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for (int i : arr) {
            if (i > 0) {
                s.add(i);
            }
        }
        for (int i = 1; i < arr.length + 1; i++) {
            if (!s.contains(i)) {
                System.out.println("The answer is: " + i);
            }
        }
    }
}

// Better solution, O(n) time and O(1) space
public class SmallestNotInSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert array separated by spaces:");
        String[] arr = scanner.nextLine().split(" ");
        int[] arrInt = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        smallestNotInSequence(arrInt);
    }

    public static void smallestNotInSequence(int[] arr) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            nums[i] = 0;

            while (true) {
                if (x < 1 || x > n || x == nums[x - 1]) break;

                int y = nums[x - 1];
                nums[x - 1] = x;
                x = y;
            }
        }

        // second loop
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) return i + 1;
        }

        return n + 1;
    }
}