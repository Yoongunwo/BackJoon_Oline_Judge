import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Main {
    static void mergeSort(Vector<String> vector, Vector<Integer> index, int n, int m) {
        if (m - n > 0) {
            int center = (m + n) / 2;
            mergeSort(vector, index, n, center);
            mergeSort(vector, index, center + 1, m);
            merge(vector, index, n, center, m);
        }
    }

    static void merge(Vector<String> vector, Vector<Integer> index, int n, int c, int m) {
        int i = n;
        int j = c + 1;
        Vector<String> new_vec = new Vector<>();
        Vector<Integer> new_index = new Vector<>();
        while (i <= c && j <= m) {
            if (vector.get(i).compareTo(vector.get(j)) < 0) {
                new_vec.add(vector.get(i));
                new_index.add(index.get(i++));
            } else {
                new_vec.add(vector.get(j));
                new_index.add(index.get(j++));
            }
        }
        while (i <= c) {
            new_vec.add(vector.get(i));
            new_index.add(index.get(i++));
        }
        while (j <= m) {
            new_vec.add(vector.get(j));
            new_index.add(index.get(j++));
        }

        for (i = 0; i < new_vec.size(); i++) {
            vector.set(n, new_vec.get(i));
            index.set(n++, new_index.get(i));
        }
    }

    static int binary_search(Vector<String> vector, Vector<Integer> index, String find, int n, int m) {
        int center = (m + n) / 2;
        if (vector.get(center).equals(find)) return index.get(center);
        else if (find.compareTo(vector.get(center)) < 0) {
            return binary_search(vector, index, find, n, center - 1);
        } else {
            return binary_search(vector, index, find, center + 1, m);
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        Vector<String> vector = new Vector<>();
        Vector<Integer> index = new Vector<>();
        Vector<String> sort = new Vector<>();
        for (int i = 0; i < n; i++) {
            String s =br.readLine();
            vector.add(s);
            sort.add(s);
            index.add(i);
        }
        mergeSort(sort, index, 0, sort.size()-1);
        for(String it : sort){
            System.out.print(it);
        }
        for (int i = 0; i < m; i++) {
            String b = br.readLine();
            try {
                int a = Integer.parseInt(b);
                sb.append(vector.get(a - 1)).append("\n");
            } catch (Exception e) {
                sb.append(binary_search(sort, index, b,  0, sort.size()-1)+1).append("\n");

            }
        }
        System.out.print(sb);
    }
}
