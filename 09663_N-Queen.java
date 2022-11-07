import java.util.Scanner;

public class Main{
    static int n;
    static int[][] arr;
    static int count = 0;
    static public void N_Queens(int row){
        if(row == n){
            count++;
            return;
        }
        go :
        for(int i=0; i<n; i++){
            for(int j=0; j<row; j++){
                if(arr[j][1] == i) continue go;
                if(Math.abs(row - j) == Math.abs(arr[j][1] - i)) continue go;
            }
            arr[row][1] = i;
            N_Queens(row+1);
        }
    }
    public static void main(String[] args){
        n = new Scanner(System.in).nextInt();
        arr = new int[n][2];
        N_Queens(0);
        System.out.print(count);
    }
}
