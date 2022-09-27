import java.util.Scanner;

public class Main {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<arr.length; i++) arr[i] = scanner.nextInt();
        for(int i=arr.length; i>0; i--){
            for(int j=0; j < i-1; j++){
                if(arr[j] > arr[j+1] ) swap(arr, j, j+1);
            }
        }
        for(int i : arr) System.out.println(i);
    }
}
