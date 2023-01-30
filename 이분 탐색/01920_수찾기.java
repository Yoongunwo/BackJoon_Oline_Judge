import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    static int[] tree;
    static void mergeSort(int low, int high){
        if(high - low <= 0) {
            return;
        }
        int mid = (high+low)/2;
        mergeSort(low, mid); mergeSort(mid+1, high);
        merge(low, mid, high);
    }
    static void merge(int low, int mid, int high){
        int[] newArr = new int[high - low + 1];
        int l = low;
        int h = mid+1;
        int newArrIndex = 0;
        while (l <= mid && h <= high) {
            if (tree[l] < tree[h]) {
                newArr[newArrIndex++] = tree[l++];
            } else {
                newArr[newArrIndex++] = tree[h++];
            }
        }
        while(l <= mid) {
            newArr[newArrIndex++] = tree[l++];
        }
        while(h <= high){
            newArr[newArrIndex++] = tree[h++];
        }
        for (int i : newArr) {
            tree[low++] = i;
        }
    }
    static boolean binarySearch(int n, int low, int high){
        int mid = (high+low)/2;
        if(low == high){
            return n==tree[mid];
        }
        if(n < tree[mid]){
            return binarySearch(n, low, mid-1);
        }else if(n > tree[mid]){
            return binarySearch(n, mid+1, high);
        }else{
            return true;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        String[] arr = scanner.nextLine().split(" ");

        tree = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            tree[i] = Integer.parseInt(arr[i]);
        }
        
        mergeSort(0, tree.length-1);

        scanner.nextLine();
        arr = scanner.nextLine().split(" ");
        int[] findNum = new int[arr.length];
        for(int i=0; i < findNum.length; i++){
            findNum[i] = Integer.parseInt(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<findNum.length; i++){
            if(binarySearch(findNum[i], 0, tree.length-1)){
                sb.append("1\n");
            }else{
                sb.append("0\n");
            }
        }
        System.out.print(sb);
    }
}
