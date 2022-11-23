import java.util.Scanner;

public class Main {
    static int[] steps;
    static int[][] sum_steps;

    static void dp(int check, int current_step, int sum) {
        if(current_step < 2) return;
        if (check == 1) {
            if (sum_steps[current_step - 1][0] > sum + steps[current_step - 1]) return;
            sum_steps[current_step - 1][0] = sum + steps[current_step - 1];
            dp(2, current_step - 1, sum_steps[current_step - 1][0]);
        }
        if (sum_steps[current_step - 2][1] > sum + steps[current_step - 2]) return;
        sum_steps[current_step - 2][1] = sum + steps[current_step - 2];
        dp(1, current_step - 2, sum_steps[current_step-2][1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        steps = new int[n + 1];
        for (int i = 1; i <= n; i++)
            steps[i] = scanner.nextInt();

        sum_steps = new int[n + 1][2];
        dp(1, n, 0);
        int max0 = Math.max(sum_steps[0][0], sum_steps[0][1]);
        int max1 = Math.max(sum_steps[1][0], sum_steps[1][1]);

        System.out.print(Math.max(max1, max0)+steps[n]);
    }
}
