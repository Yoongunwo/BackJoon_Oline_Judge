import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int test_case = scanner.nextInt();
        while(test_case-- > 0){
            int n = scanner.nextInt();
            loops:
            for(int i = n/2; i>1; i--){
                for(int j=2; j<=Math.sqrt(n-i); j++)
                    if(i%j == 0 || (n-i)%j == 0 ) continue loops;
                System.out.print(i + " " + (n-i) + "\n");
                break;
            }
        }
    }
}
