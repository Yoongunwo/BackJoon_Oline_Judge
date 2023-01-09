import java.util.Scanner;

public class Main {
    static int[][] matrix;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int sRow, int sCol, int eRow, int eCol) {
        for (int i = sRow; i < eRow; i++) {
            for (int j = sCol; j < eCol; j++){
                if(matrix[i][j] != matrix[sRow][sCol]){
                    sb.append("(");
                    int cRow = (eRow+sRow)/2;
                    int cCol = (eCol+sCol)/2;
                    dfs(sRow, sCol, cRow, cCol);
                    dfs(sRow, cCol, cRow, eCol);
                    dfs(cRow, sCol, eRow, cCol);
                    dfs(cRow, cCol, eRow, eCol);
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(matrix[sRow][sCol]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            String str = scanner.next();
            for (int j = 0; j < size; j++) {
                matrix[i][j] = str.charAt(j) - 48;
            }
        }
        dfs(0,0, size, size);
        System.out.print(sb);
    }
}
