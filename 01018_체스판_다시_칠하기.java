import java.util.Scanner;

public class Main {
    static int check(char[][] board, int i, int j) {
        int count = 0;
        int count1 = 0;

        char ch;
        ch = 'B';
        for (int m = i; m < i + 8; m++) {
            for (int n = j; n < j + 8; n++) {
                if (ch != board[m][n]) count++;
                if (ch == 'B') ch = 'W';
                else ch = 'B';
            }
            if (ch == 'B') ch = 'W';
            else ch = 'B';
        }
        ch = 'W';
        for (int m = i; m < i + 8; m++) {
            for (int n = j; n < j + 8; n++) {
                if (ch != board[m][n]) count1++;
                if (ch == 'B') ch = 'W';
                else ch = 'B';
            }
            if (ch == 'B') ch = 'W';
            else ch = 'B';
        }
        if( count < count1)return count;
        return count1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();

        char[][] board = new char[row][col];
        for (int i = 0; i < row; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < col; j++) board[i][j] = s.charAt(j);
        }

        int min = 64;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                int a = check(board, i, j);
                if( a < min) min = a;
            }
        }
        System.out.print(min);
    }
}
