import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n + 1];

        arr[n] = 0;
        arr[n - 1] = 1;
        for (int i = n - 1; i > 0; i--) {
            if (i * 3 <= n && i * 2 <= n) {
                arr[i] = Math.min(arr[i * 3], arr[i * 2]);
                arr[i] = Math.min(arr[i+1], arr[i])+1;
            } else if (i * 2 <= n) {
                arr[i] = Math.min(arr[i + 1], arr[i * 2]) + 1;
            } else {
                arr[i] = arr[i + 1] + 1;
            }
        }
        System.out.print(arr[1]);
    }
}
