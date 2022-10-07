import java.io.*;
import java.util.Stack;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        Vector<Character> vec = new Vector<>();
        int i = 0;
        for (int j = 1; j <= num && i < num; ) {
            if (j > arr[i]) {
                if ( stack.empty() || stack.pop() != arr[i]) {
                    System.out.println("NO");
                    System.exit(0);
                }
                vec.add('-');
                i++;
            } else {
                do {
                    stack.push(j);
                    vec.add('+');
                } while (j++ != arr[i]);
                i++;
                stack.pop();
                vec.add('-');
            }
        }
        while (!stack.empty()) {
            if (arr[i++] != stack.pop()) {
                System.out.print("NO");
                System.exit(0);
            } else {
                vec.add('-');
            }
        }
        for(char c : vec){
            bw.write(c + "\n");
        }
        bw.flush();
    }
}
