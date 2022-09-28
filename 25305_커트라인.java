import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void quickSort(int[] arr, int low, int high){
        int a = low, b= high;
        if(high-low <= 0 ) return;
        int pivot = low++;
        while(high > low){
            if(arr[high] > arr[pivot]) high--;
            if(arr[low] < arr[pivot]) low++;
            if(arr[low] > arr[pivot] && arr[high] < arr[pivot]) swap(arr, low++, high--);
        }
        swap(arr, pivot, high);
        quickSort(arr, a, high-1);
        quickSort(arr, low, b);
    }
    static int[] mergeSort(int[] arr, int low, int high){
        int[] new_arr = new int[high-low+1];
        if(high-low <= 0){
            new_arr[0] = arr[low];
            return new_arr;
        }

        int[] a = mergeSort(arr, low, (high+low)/2);
        int[] b = mergeSort(arr, (high+low)/2+1, high);
        int i=0, j=0;
        while(i<a.length && j< b.length){
            if(a[i] < b[j]) new_arr[i+j] = a[i++];
            else new_arr[i+j] = b[j++];
        }
        if (i >= a.length) {
            while (j < b.length) new_arr[i + j] = b[j++];
        }
        else{
            while (i < a.length) new_arr[i + j] = a[i++];
        }
        return new_arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int human = Integer.parseInt(st.nextToken());
        int award = Integer.parseInt(st.nextToken());

        int[] arr = new int[human];
        st = new StringTokenizer(br.readLine(), " ");
        int i=0;
        while(st.hasMoreTokens()) arr[i++] = Integer.parseInt(st.nextToken());
        arr = mergeSort(arr, 0, arr.length-1);
        System.out.println(arr[arr.length-award]);
    }
}
