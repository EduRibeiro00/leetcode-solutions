import java.util.Scanner;

public class URLify {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the string:");
        String str = scanner.nextLine();
        System.out.println("Input the true length of the string:");
        int len = scanner.nextInt();

        urlify(str.toCharArray(), len);
    }

    public static void urlify(char[] str, int len) {
        int i = 0;
        while (i < len) {
            char cur = str[i];
            if (cur != ' ') {
                i++;
                continue;
            }
            // 1st character
            str[i] = '%';

            // move all chars two positions forward
            for (int j = len-1; j > i; j -= 2) {
                str[j+2] = str[j];
                str[j+1] = str[j-1];
            }

            // 2nd and 3rd characters
            str[i+1] = '2';
            str[i+2] = '0';

            len += 2;
        }

        System.out.println(new String(str));
    }
}
