import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int start = n;
        for (int i = 1; i <= n; i *= 10) {
            start -= 9;
        }
        while(start < n) {
            int j = start++;
            int sum = j;
            while(j>0){
                sum += j%10;
                j/=10;
            }
            if(sum == n) {
                System.out.print(start);
                System.exit(0);
            }
        }
        System.out.println(0);
    }
}
