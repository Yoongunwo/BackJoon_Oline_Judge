import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] matrix = new int[num][2];
        for(int i=0; i<num; i++){
            matrix[i][0] = scanner.nextInt();
            matrix[i][1] = scanner.nextInt();
        }
        for(int i =0; i<num-1; i++){
            int min = matrix[i][0];
            int min_index = i;
            for(int j=i+1; j<num; j++){
                if(matrix[j][0] < min){
                    min = matrix[j][0];
                    min_index = j;
                }
            }
            int min2 = matrix[min_index][1];
            matrix[min_index][0] = matrix[i][0];
            matrix[min_index][1] = matrix[i][1];
            matrix[i][0] = min;
            matrix[i][1] = min2;
        }
//        for(int i=0; i<num; i++){
//            System.out.println(matrix[i][0] + " " + matrix[i][1]);
//        }
        int[] dp = new int[num];
        dp[0] = 1;
        int count = 0;
        for(int i=1; i<num; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(matrix[j][1] < matrix[i][1]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
            count = Math.max(dp[i], count);
        }
        System.out.print(num- count);
    }
}
