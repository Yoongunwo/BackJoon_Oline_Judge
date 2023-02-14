import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int row = Integer.parseInt(strings[0]);
        int col = Integer.parseInt(strings[1]);
        int need = Integer.parseInt(strings[2]);

        char[][] board = new char[row][];
        int[][] black = new int[row][col + 2];
        for (int i = 0; i < row; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'B') {
                    black[i][j + 2]++;
                }
                black[i][j + 2] += black[i][j];
            }
        }

        int firstNeed = need - need / 2;
        int secondNeed = need / 2;

        int findResult = 2000000;
        if (need % 2 == 0) {
            for (int j = 0; j <= col - need; j++) {
                int result = 0;
                int flag = 0;
                for (int r = 0; r < need; r++) {
                    int first = black[r][j + need + 1] - black[r][j + 1];
                    int second = black[r][j + need] - black[r][j];
                    if (flag == 0) {
                        result += firstNeed - first;
                        result += second;
                        flag = 1;
                    } else {
                        result += first;
                        result += secondNeed - second;
                        flag = 0;
                    }
                }
                int nflag = 0;
                for (int i = 0; i < row - need; i++) {
                    findResult = Math.min(findResult, result);
                    findResult = Math.min(findResult, need * need - result);

                    int minusFirst = black[i][j + need + 1] - black[i][j + 1];
                    int minusSecond = black[i][j + need] - black[i][j];
                    int plusFirst = black[i + need][j + need + 1] - black[i + need][j + 1];
                    int plusSecond = black[i + need][j + need] - black[i+need][j];
                    if (nflag == 0) {
                        result -= firstNeed - minusFirst;
                        result -= minusSecond;
                        result += firstNeed - plusFirst;
                        result += plusSecond;

                        nflag = 1;
                    } else {
                        result -= minusFirst;
                        result -= secondNeed - minusSecond;
                        result += plusFirst;
                        result += secondNeed - plusSecond;

                        nflag = 0;
                    }
                }
                findResult = Math.min(findResult, result);
                findResult = Math.min(findResult, need * need - result);
            }
        } else {
            for (int j = 0; j <= col - need; j++) {
                int result = 0;
                int flag = 0;
                for (int r = 0; r < need; r++) {
                    int first = black[r][j + need + 1] - black[r][j];
                    int second = black[r][j + need] - black[r][j + 1];
                    if (flag == 0) {
                        result += firstNeed - first;
                        result += second;
                        flag = 1;
                    } else {
                        result += first;
                        result += secondNeed - second;
                        flag = 0;
                    }
                }
                int nflag = 0;
                for (int i = 0; i < row - need; i++) {
                    findResult = Math.min(findResult, result);
                    findResult = Math.min(findResult, need * need - result);

                    int minusFirst = black[i][j + need + 1] - black[i][j];
                    int minusSecond = black[i][j + need] - black[i][j + 1];
                    int plusFirst = black[i + need][j + need + 1] - black[i + need][j];
                    int plusSecond = black[i + need][j + need] - black[i+need][j + 1];
                    if (nflag == 0) {
                        result -= firstNeed - minusFirst;
                        result -= minusSecond;
                        result += plusFirst;
                        result += secondNeed - plusSecond;

                        nflag = 1;
                    } else {
                        result -= minusFirst;
                        result -= secondNeed - minusSecond;
                        result += firstNeed - plusFirst;
                        result += plusSecond;

                        nflag = 0;
                    }
                }
                findResult = Math.min(findResult, result);
                findResult = Math.min(findResult, need * need - result);
            }
        }
        System.out.println(findResult);
    }
}
