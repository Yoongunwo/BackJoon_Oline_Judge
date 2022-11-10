import java.util.Scanner;

public class Main {
    static int[][] ability;
    static int n;
    static int min = 10000000;
    static void calculate(int[] team1) {
        boolean[] check = new boolean[n];
        for (int i = 0; i < team1.length; i++) {
            check[team1[i]] = true;
        }
        int[] team2 = new int[n / 2];
        int index = 0;
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) team2[index++] = i;
        }

        int sum = 0;
        for (int i = 0; i < team1.length - 1; i++) {
            for (int j = i + 1; j < team1.length; j++) {
                sum += ability[team1[i]][team1[j]];
                sum += ability[team1[j]][team1[i]];
                sum -= ability[team2[i]][team2[j]];
                sum -= ability[team2[j]][team2[i]];
            }
        }
        min = Math.min(min, Math.abs(sum));
    }

    static void dfs(int player, int[] team1, int m) {
        if (player == n / 2) {
            calculate(team1);
            return;
        }
        for (int i = m; i < n; i++) {
            team1[player] = i;
            dfs(player + 1, team1, i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ability = new int[n][n];

        for (int i = 0; i < ability.length; i++)
            for (int j = 0; j < ability[0].length; j++)
                ability[i][j] = scanner.nextInt();

        int[] team1 = new int[n / 2];
        team1[0] = 0;
        dfs(1, team1, 1);
        System.out.print(min);
    }
}
