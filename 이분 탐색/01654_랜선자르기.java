import java.util.Arrays;
import java.util.Scanner;

public class Main{
    static int[] lengths;
    static int goal;
    static long binarySearch(long l, long h){
        if(l+1 == h || l == h){
            return l;
        }
        long mid = (h+l)/2;
        long num = 0;
        for(int i : lengths){
            num += i/mid;
        }
        if(num < goal){
            return binarySearch(l, mid);
        }else{
            return binarySearch(mid, h);
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int current = scanner.nextInt();
        goal = scanner.nextInt();

        lengths = new int[current];
        long sum = 0;
        for(int i=0; i<lengths.length; i++){
            lengths[i] = scanner.nextInt();
            sum += lengths[i];
        }
        Arrays.sort(lengths);

        System.out.println(binarySearch(1, lengths[lengths.length-1]+1));
    }
}
