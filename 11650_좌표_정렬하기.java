import java.util.Scanner;

public class Main {
    static int[][] mergeSort(int[][] arr, int low, int high) {
        int[][] new_arr = new int[high - low + 1][2];
        if (high - low <= 0) {
            new_arr[0][0] = arr[low][0];
            new_arr[0][1] = arr[low][1];
            return new_arr;
        }
        int[][] a = mergeSort(arr, low, (high + low) / 2);
        int[][] b = mergeSort(arr, (high + low) / 2 + 1, high);

        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i][0] == b[j][0]) {
                if (a[i][1] > b[j][1]) {
                    new_arr[i + j][0] = b[j][0];
                    new_arr[i + j][1] = b[j++][1];
                }else if (a[i][1] < b[j][1]) {
                    new_arr[i + j][0] = a[i][0];
                    new_arr[i + j][1] = a[i++][1];
                }
            } else if (a[i][0] < b[j][0]) {
                new_arr[i + j][0] = a[i][0];
                new_arr[i + j][1] = a[i++][1];
            } else if (a[i][0] > b[j][0]){
                new_arr[i + j][0] = b[j][0];
                new_arr[i + j][1] = b[j++][1];
            }
        }
        while (i < a.length) {
            new_arr[i + j][0] = a[i][0];
            new_arr[i + j][1] = a[i++][1];
        }
        while (j < b.length){
            new_arr[i + j][0] = b[j][0];
            new_arr[i + j][1] = b[j++][1];
        }
        return new_arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] matrix = new int[num][2];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        matrix = mergeSort(matrix, 0, matrix.length - 1);

        for (int i = 0; i < num; i++) {
            System.out.println(matrix[i][0] + " " + matrix[i][1]);
        }

    }
}
