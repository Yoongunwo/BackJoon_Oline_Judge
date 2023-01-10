import java.util.Scanner;

public class Main{
    static int[][] matrixA;
    static int[][] matrixB;
    static int[][] newMatrix;
    static int matrixMul(int row, int col){
        int result =0;
        for(int i=0; i<matrixA[row].length; i++) {
            result += matrixA[row][i] * matrixB[i][col];
        }
        return result;
    }
    public static void main(String[] ags){
        Scanner scanner = new Scanner(System.in);

        matrixA = new int[scanner.nextInt()][scanner.nextInt()];
        for(int i=0; i<matrixA.length; i++){
            for(int j=0; j<matrixA[0].length; j++){
                matrixA[i][j] = scanner.nextInt();
            }
        }
        matrixB = new int[scanner.nextInt()][scanner.nextInt()];
        for(int i=0; i<matrixB.length; i++){
            for(int j=0; j<matrixB[0].length; j++){
                matrixB[i][j] = scanner.nextInt();
            }
        }
        newMatrix = new int[matrixA.length][matrixB[0].length];
        for(int i=0; i<newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                newMatrix[i][j] =  matrixMul(i,j);
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
