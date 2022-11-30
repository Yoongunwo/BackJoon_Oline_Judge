package BackJoon2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long a = new Scanner(System.in).nextInt();
        long[] arr = new long[10];
        long[] new_arr;

        arr[0] = 0;
        for (int i = 1; i < 10; i++) {
            arr[i] = 1;
        }

        for (int i = 1; i < a; i++) {
            new_arr = new long[10];

            for (int j = 0; j < 10; j++) {
                if (j == 0) new_arr[j] += arr[1];
                else if (j == 9) new_arr[j] += arr[8];
                else {
                    new_arr[j] += arr[j + 1];
                    new_arr[j] += arr[j - 1];
                    new_arr[j] %= 1000000000;
                }
            }
            arr = new_arr;
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += arr[i];
            sum %= 1000000000;
        }
        System.out.println(sum);
        
    }
}
