import java.io.*;
public class Main{
    static int[] Merge(int[] arr, int low, int high){
        int[] a, b;
        int[] new_arr = new int[high-low+1];
        if(high-low >= 1){
            a = Merge(arr, low, (low+high)/2); b = Merge(arr, (low+high)/2+1, high);
        }
        else{
            new_arr[0] = arr[low];
            return new_arr;
        };
            int i = 0;
            int j = 0;
        while (true) {
            if (i >= a.length || j >= b.length) {
                if (i >= a.length) {
                    while (j < b.length) {
                        new_arr[i + j] = b[j++];
                    }
                } else {
                    while (i < a.length) {
                        new_arr[i + j] = a[i++];
                    }
                }
                break;
            }
            if (a[i] < b[j]) {
                new_arr[i + j] = a[i++];
            }
            else new_arr[i + j] = b[j++];
        }
        return new_arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[Integer.parseInt(br.readLine())];
        for(int i=0; i<arr.length; i++) arr[i] = Integer.parseInt(br.readLine());
        br.close();
        arr = Merge(arr,0,arr.length-1);
        for(int i : arr) bw.write(i + "\n");
        bw.flush();
    }
}
