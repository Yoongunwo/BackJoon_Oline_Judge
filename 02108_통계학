import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static void counting(int[] arr, int[] counting, int min) {
        for (int i : arr) counting[i-min]++;
    }

    static int[] countingSort(int[] arr, int[] count_arr, int max, int min) {
        int[] new_arr = new int[arr.length+1];

        int a = 0;
        for(int i=0; i<count_arr.length; i++){
            if(count_arr[i] != 0){
                count_arr[i] += a;
                a = count_arr[i];
            }
        }
        for(int i=0; i<arr.length; i++){
            new_arr[count_arr[arr[i]-min]--] = arr[i];
        }

        return new_arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        arr[0] = Integer.parseInt(br.readLine());
        int max = arr[0], min = arr[0];

        for(int i=1; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }

        int[] count_arr= new int[max-min+1];
        counting(arr, count_arr, min);
        int[] new_arr = countingSort(arr, count_arr, max, min);

        int sum = 0;
        for(int i : new_arr) sum +=i;
        System.out.println(Math.round((float)sum/n) + "\n" + new_arr[new_arr.length/2]);

        int a =0;
        int num = 0;

        count_arr= new int[max-min+1];
        counting(arr, count_arr, min);

        for(int i: count_arr){
            if(i>a){
                num =1; a=i;
            }
            else if( i == a) num++;
        }
        if(num == 1){
            for(int i=0; i<count_arr.length; i++){
                if(count_arr[i] == a) System.out.println(i+min + "\n" + (max-min));
            }
        }else{
            int b =0;
            for(int i=0; i<count_arr.length; i++){
                if(count_arr[i] == a){
                    if(b == 1) {
                        System.out.println(i + min + "\n" + (max - min));
                        break;
                    }
                    b++;
                }
            }
        }
    }
}
