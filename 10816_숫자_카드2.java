import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        HashMap<Integer, Integer> map = new HashMap<>();
        while (st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            if (!map.containsKey(a)) map.put(a, 1);
            else {
                int b = map.get(a);
                map.replace(a, ++b);
            }
        }

        num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            if(map.containsKey(a)) bw.write(map.get(a) + " ");
            else bw.write(0 + " ");
        }
        bw.flush();
    }
}
