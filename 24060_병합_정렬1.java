import java.util.Scanner;

public class Main {
    static int save = 0;
    static int record;
    void mergeSort(int[] arr, int l, int h) {
        if (h > l) {
            int c = (h + l) / 2;
            mergeSort(arr, l, c);
            mergeSort(arr, c + 1, h);
            merge(arr, l, c, h);
        }
    }

    void merge(int[] arr, int l, int c, int h) {
        int[] new_arr = new int[h - l + 1];
        int t = 0;
        int i = l, j = c + 1;
        while (i <= c && j <= h) {
            if (arr[i] < arr[j]) {
                new_arr[t++] = arr[i++];
            } else {
                new_arr[t++] = arr[j++];
            }
        }
        while (i <= c) new_arr[t++] = arr[i++];
        while (j <= h) new_arr[t++] = arr[j++];
        t = 0;
        while (l <= h) {
            if(++save == record) System.out.print(new_arr[t]);
            arr[l++] = new_arr[t++];
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        record = scanner.nextInt();
        scanner.nextLine();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        new Main().mergeSort(arr, 0, size - 1);
        if(save < record ) System.out.print(-1);
    }
}
