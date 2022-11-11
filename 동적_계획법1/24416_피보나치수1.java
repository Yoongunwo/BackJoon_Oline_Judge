import java.util.Scanner;

public class Main {
    static int countNotDp = 0;
    static int countDp = 0;

    static int fibonacci(int n) {
        if (1 == n || 2 == n) {
            countNotDp++;
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    static void dpFibonacci(int index, int n, int[] arr) {
        if (index == n + 1) return;
        if (index == 1 || index == 2) {
            arr[index] = 1;
        } else {
            countDp++;
            arr[index] = arr[index - 1] + arr[index - 2];
        }
        dpFibonacci(index + 1, n, arr);
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        fibonacci(n);
        int[] arr = new int[n + 1];
        dpFibonacci(1, n, arr);
        System.out.print(countNotDp + " " + countDp);
    }
}
