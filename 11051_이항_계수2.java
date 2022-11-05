package BackJoon1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int[][] binomial = new int[a + 1][];
        for (int i = 0; i <= a; i++) {
            binomial[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) binomial[i][j] = 1;
                else binomial[i][j] = (binomial[i - 1][j - 1] + binomial[i - 1][j]) %10007;
            }
        }
        sb.append(binomial[a][b]).append("\n");

        System.out.println(sb);
    }
}
