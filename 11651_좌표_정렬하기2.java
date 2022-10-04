import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] matrix = new int[num][2];
        for(int i =0 ;i<num; i++){
            matrix[i][0] = scanner.nextInt();
            matrix[i][1] = scanner.nextInt();
        }

        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                else return o1[1] - o2[1];
            }
        });

        for(int i=0; i<num; i++){
            System.out.println(matrix[i][0] + " " + matrix[i][1]);
        }
    }
}
