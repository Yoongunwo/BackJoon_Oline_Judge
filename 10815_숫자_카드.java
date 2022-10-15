import java.util.HashMap;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Boolean> map = new HashMap<>();

        int n = scanner.nextInt();
        scanner.nextLine();

        for(int i=0; i<n; i++){
            map.put(scanner.nextInt(), true);
        }
        scanner.nextLine();

        n = scanner.nextInt();
        for(int i=0; i < n; i++){
            if(map.containsKey(scanner.nextInt())) sb.append(1 + " ");
            else sb.append(0 + " ");
        }
        System.out.print(sb);
    }
}
