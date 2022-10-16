import java.util.HashMap;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt(); int m = scanner.nextInt();
        scanner.nextLine();
        int max = n+m;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(n-->0){
            int a = scanner.nextInt();
            map.put(a, 1);
        }
        int count = 0;
        while(m-->0){
            int a = scanner.nextInt();
            if(map.containsKey(a)) count++;
        }
        System.out.print(max-count*2);
    }
}
