import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchShiftedArray {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        
        int num = sc.nextInt();
        int len = sc.nextInt();
        int[] array = new int[len];

        int i = 0;
        while (sc.hasNextInt() && i < len) {
            array[i] = sc.nextInt();
            i++;
        }

        System.out.println("The answer is: " + searchShiftedArray(array, num));
    }

    public static int searchShiftedArray(int[] array, int num) {
        if (array == null || array.length < 1) return -1;
        if (array.length == 0 && array[0] == num) return 0;

        int low = 0;
        int high = array.length - 1;
        int pivot = -1;

        // binary search to find the pivot
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // we are in the second part of the array - pivot to the left
            if (array[mid] < array[0]) {
                high = mid - 1;
            }
            // we have found the pivot
            else if (mid > 0 && mid < array.length - 1 && array[mid] > array[mid-1] && array[mid] > array[mid+1]) {
                pivot = mid;
                break;
            }
            // we are in the first part of the array - pivot to the right
            else if (array[mid] > array[0]) {
                low = mid + 1;
            }
        }

        if (pivot == -1) return -1;

        System.out.println("Pivot: a[" + pivot + "] = " + array[pivot]);
        if (num == array[pivot]) return pivot;

        // check if the number we want is in the left part of right part of the array
        boolean leftSide = (num > array[0] && num < array[pivot]);

        // perform regular binary search to find the element
        return leftSide ? binarySearch(array, num, 0, pivot) : binarySearch(array, num, pivot+1, array.length - 1);
    }

    public static int binarySearch(int[] array, int num, int lowInit, int highInit) {
        int low = lowInit;
        int high = highInit;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] > num)
                high = mid - 1;
            else if (array[mid] < num)
                low = mid + 1;
            else
                return mid;
        }

        return -1;
    }
}
