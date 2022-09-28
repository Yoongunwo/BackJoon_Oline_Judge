import java.io.*;

public class Main{
    static int[] countingSort(int[] arr, int max){
        int[] counting = new int[max+1];
        int[] recurrence = new int[max+1];
        for(int i : arr) {
            counting[i]++;
            recurrence[i]++;
        }
        int recur = 0;
        for(int i =0; i<recurrence.length; i++){
            if(recurrence[i] != 0) recurrence[i] += recur;
            recur += counting[i];
        }
        int[] new_arr = new int[arr.length+1];
        for(int i=0; i<arr.length; i++){
            int index = recurrence[arr[i]]--;
            new_arr[index] = arr[i];
        }
        return new_arr;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        for(int i=0; i<n;i++) {
            int a = Integer.parseInt(br.readLine());
            if( a > max) max = a;
            arr[i] = a;
        }
        arr = countingSort(arr,max);
        for(int i= 1; i<arr.length; i++){
            bw.write(arr[i] + "\n");
        }
        bw.flush();
    }
}
