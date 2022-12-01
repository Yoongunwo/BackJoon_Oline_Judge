import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[][] select = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        if (n >= 1) {
            select[0][0] = arr[0];
            select[0][1] = arr[0];
            select[0][2] = 0;
        }
        if (n > 1) {
            select[1][0] = arr[0] + arr[1];
            select[1][1] = arr[1];
            select[1][2] = arr[0];
        }
        for (int i = 2; i < n; i++) {
            select[i][0] = arr[i] + select[i - 1][1];
            select[i][1] = arr[i] + select[i - 1][2];
            select[i][2] = Math.max(select[i - 1][2], Math.max(select[i - 1][0], select[i - 1][1]));
        }
        System.out.print(Math.max(select[n-1][2],Math.max(select[n-1][0],select[n-1][1])));
    }
}
