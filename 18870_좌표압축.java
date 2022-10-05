import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Vector<Integer> ori = new Vector<>();
        HashSet<Integer> set = new HashSet<>();

        while(st.hasMoreTokens()){
            int a = Integer.parseInt(st.nextToken());
            ori.add(a);
            set.add(a);
        }

        Vector<Integer> vec = new Vector<>(set);
        vec.sort(Comparator.comparingInt(o -> o));

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<vec.size(); i++){
            map.put(vec.get(i), i);
        }

        for(Integer integer : ori){
            bw.write(map.get(integer) + " ");
        }
        bw.flush();
    }
}
