import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        Vector<Integer> vec = new Vector<>();

        int i = 1;
        loops:
        while(i++ < n){
            for(Integer it : vec){
                if(i % it == 0) continue loops;
            }
            vec.add(i);
            if(i>=m) bw.write(i + "\n");
        }
        bw.flush();

        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int j=m; j<=n; j++){
            map.put(j, true);
        }

    }
}
