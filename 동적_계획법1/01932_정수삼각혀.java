import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        arr1[0] = scanner.nextInt();
        arr2[0] = arr1[0];
        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
                arr1[j] = scanner.nextInt();
            }
            arr1[0] += arr2[0];
            arr1[i] += arr2[i-1];
            for(int j=1; j<i; j++){
                arr1[j] += Math.max(arr2[j], arr2[j-1]);
                arr2[j-1] = arr1[j-1];
            }
            arr2[i-1] = arr1[i-1];
            arr2[i] = arr1[i];
        }
        Arrays.sort(arr2);
        System.out.print(arr2[n-1]);
    }
}
