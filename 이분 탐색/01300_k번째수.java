import java.util.Scanner;

public class Main {
    static int size;
    static long findNum(long num) {
        long count = 0;
        for(int i=1; i<= num && i<=size; i++){
            count += num/i > size ? size : num/i;
        }
        return count;
    }
    static long binarySearch(int findIndex, long l, long h) {
        while (h > l) {
            long mid = (h + l) / 2;
            long index = findNum(mid);
            if(index < findIndex){
                l = mid + 1;
            }else{
                h = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        int findIndex = scanner.nextInt();
        System.out.print(binarySearch(findIndex, 1, (long) size * size));
    }
}
