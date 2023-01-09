import java.util.Scanner;

public class Main {
    static int[][] matrix;
    static int nOne;
    static int pOne;
    static int zero;

    static void dfs(int row, int col, int n) {
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (matrix[i][j] != matrix[row][col]) {
                    n = n / 3;
                    dfs(row, col, n);
                    dfs(row, col+n, n);
                    dfs(row, col+n*2, n);
                    dfs(row+n, col, n);
                    dfs(row+n, col+n, n);
                    dfs(row+n, col+n*2, n);
                    dfs(row+n*2, col, n);
                    dfs(row+n*2, col+n, n);
                    dfs(row+n*2, col+n*2, n);
                    return;
                }
            }
        }
        if(matrix[row][col] == -1) nOne++;
        else if(matrix[row][col] == 0) zero++;
        else pOne++;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        dfs(0,0,size);
        System.out.println(nOne);
        System.out.println(zero);
        System.out.println(pOne);
    }
}
