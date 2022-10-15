import java.util.HashSet;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashSet<String> hs = new HashSet<String>();
        for(int i=0; i<n; i++)
            hs.add(scanner.nextLine());
        int count = 0;
        for(int i=0; i<m; i++){
            if(hs.contains(scanner.nextLine())) count++;
        }
        System.out.print(count);
    }
}
