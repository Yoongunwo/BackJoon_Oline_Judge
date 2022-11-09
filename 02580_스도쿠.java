import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Main {
    static int[][] arr;
    static Vector<Integer> x;
    static Vector<Integer> y;
    static Vector<Integer> count;

    static boolean finish(){
        return x.size() == 0;
    }
    static void change(int i, int j) {
        int change_x = x.get(i);
        int change_y = y.get(i);
        int change_count = count.get(i);
        x.set(i, x.get(j));
        y.set(i, y.get(j));
        count.set(i, count.get(j));
        x.set(j, change_x);
        y.set(j, change_y);
        count.set(j, change_count);
    }

    static void sort() {
        for (int i = 0; i < x.size() - 1; i++) {
            int max = count.get(i);
            int index = i;
            for (int j = i + 1; j < x.size(); j++) {
                if (count.get(j) > max) {
                    index = j;
                    max = count.get(j);
                }
            }
            change(i, index);
        }
    }

    static void count() {
        for (int i = 0; i < x.size(); i++) {
            int n = x.get(i);
            int m = y.get(i);
            boolean[] check = new boolean[10];
            check(check, n, m);
            int c = 0;
            for (int j = 1; j <= 9; j++) {
                if (check[j]) c++;
            }
            count.add(c);
        }
    }

    static void check(boolean[] check, int i, int j) {
        for (int n = 0; n < 9; n++) {
            check[arr[n][j]] = true;
            check[arr[i][n]] = true;
        }
        i = i / 3 * 3;
        j = j / 3 * 3;
        for (int box_x = i; box_x < i + 3; box_x++) {
            for (int box_y = j; box_y < j + 3; box_y++) {
                check[arr[box_x][box_y]] = true;
            }
        }
    }

    static void dfs(int index) {
        if(finish()) {
            print();
            System.exit(0);
        }
        count.removeAllElements();
        count();
        sort();
        boolean[] check = new boolean[10];
        int x_point = x.get(index);
        int y_point = y.get(index);
        check(check, x_point, y_point);
        for(int i=1; i<10; i++){
            if(!check[i]){
                arr[x_point][y_point] = i;
                x.remove(index); y.remove(index);
                dfs(index);
                arr[x_point][y_point] = 0;
                x.add(index, x_point); y.add(index, y_point);
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9][9];
        x = new Vector<>();
        y = new Vector<>();
        count = new Vector<>();

        for(int i=0; i<9; i++){
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
                if (arr[i][j] == 0) {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        count();
        sort();
        dfs(0);
    }
}
