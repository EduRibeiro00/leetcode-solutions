import java.util.Scanner;

public class MinStepsTo1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert your number: ");
        int num = sc.nextInt();
        System.out.println("It would take a minimum of " + calcMinSteps(num) + " steps");
        sc.close();
    }

    public static int calcMinSteps(int num) {
        int[] aux = new int[num + 1];
        aux[0] = 0;
        aux[1] = 0;

        if (num <= 1)
            return aux[num];

        for (int i = 2; i < aux.length; i++) {
            int result = aux[i-1];
            
            if (i % 2 == 0)
                result = Math.min(result, aux[i / 2]);

            if (i % 3 == 0)
                result = Math.min(result, aux[i / 3]);

            aux[i] = result + 1;
        }

        return aux[num];
    }
}
