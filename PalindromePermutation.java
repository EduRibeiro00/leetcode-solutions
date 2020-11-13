import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class PalindromePermutation {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        
        String input = sc.nextLine();

        String response = palindromePermutation(input) ? "true" : "false";
        System.out.println("The answer is: " + response);
    }

    public static boolean palindromePermutation(String input) {
        char[] inputArray =  input.toCharArray();
        
        // chars that have an odd number of occurrences in the string.
        // for the string to be a palindrome, oddChars <= 1
        int oddChars = 0;

        // key - char, value - numOccurrences
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : inputArray) {
            int numOccur = map.containsKey(c) ? map.get(c) + 1 : 1;
            if (numOccur % 2 != 0)
                oddChars++;
            else
                oddChars--;
            
            map.put(c, numOccur);
        }

        return oddChars <= 1;
    }
}
