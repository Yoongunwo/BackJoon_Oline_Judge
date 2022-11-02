import java.util.Scanner;

public class Main{
    static void devide(int[] arr, int l, int h){
        if(h-l <= 0) return;
        int c = (h+l)/2;
        devide(arr, l, c); devide(arr,c+1, h);
        merge(arr, l, c, h);
    }
    static void merge(int[] arr, int l, int c, int h){
        int[] new_arr = new int[arr.length];
        int i=l; int j = c+1;
        int n = 0;
        while(true){
            if(i > c || j > h) break;
            if(arr[i] < arr[j]) new_arr[n++] = arr[i++];
            else new_arr[n++] = arr[j++];
        }
        while(i <= c){
            new_arr[n++] = arr[i++];
        }
        while(j <= h){
            new_arr[n++] = arr[j++];
        }
        for(int a=0; a<n; a++){
            arr[l++] = new_arr[a];
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num= scanner.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++) {
            arr[i] = scanner.nextInt();
        }
        devide(arr, 0, num-1);

        for(int i=2; i<=arr[1]-arr[0]; i++){
            int rest = arr[0]%i;
            int j=1;
            for(; j<arr.length; j++){
                if(arr[j]%i != rest) break;
            }
            if(j == arr.length) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
