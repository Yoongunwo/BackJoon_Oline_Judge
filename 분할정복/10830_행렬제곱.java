import java.util.Scanner;

public class Main {
    static int[][] mul(int[][] matrix1, int[][] matrix2){
        int[][] newMatrix = new int[matrix1.length][matrix1.length];
        for(int i=0; i<matrix1.length; i++){
            for(int j=0; j<matrix1.length; j++){
                for(int z=0; z<matrix1.length; z++){
                    newMatrix[i][j] +=
                            matrix1[i][z] * matrix2[z][j] ;
                    newMatrix[i][j] %= 1000;
                }
            }
        }
        return newMatrix;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        long b = scanner.nextLong();

        int[][] matrix = new int[size][size];
        int[][] result_matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
                result_matrix[i][j] = matrix[i][j];
            }
        }

        b -= 1;
        while(b != 0){
            if(b%2 == 1){
                result_matrix = mul(result_matrix, matrix);
            }

            matrix = mul(matrix, matrix);
            b /= 2;
        }


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(result_matrix[i][j]%1000 + " ");
            }
            System.out.println();
        }
    }
}
