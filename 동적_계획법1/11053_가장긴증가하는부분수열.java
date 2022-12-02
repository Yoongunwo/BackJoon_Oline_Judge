import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = scanner.nextInt();
        }
        int[][] counting = new int[num][2];
        int index = 1;
        counting[0][0] = 1;
        counting[0][1] = arr[0];
        for(int i=1; i<num; i++){
            int max = 0;
            for(int j=0; j<index; j++) {
                if (arr[i] > counting[j][1]) {
                    max = Math.max(max, counting[j][0]);
                }
            }
            counting[index][0] = max+1;
            counting[index][1] = arr[i];
            index++;
        }
        int max = 0;
        for(int i=0; i<index; i++){
            max = Math.max(max, counting[i][0]);
        }
        System.out.print(max);
    }
}
