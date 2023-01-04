import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int size = 0;
		int num = Integer.parseInt(br.readLine());
		int last = 0;
		
		for(int i=0; i<num; i++) {
			String[] command = br.readLine().split(" ");
			
			switch(command[0]) {
				case "push"	:
					int x = Integer.parseInt(command[1]);
					last = x;
					queue.add(x);
					size++;
					break;
				case "pop" :
					Integer a = queue.poll();
					if(a == null) {
						bw.write("-1\n");
					}else {
						bw.write(a + "\n");
					}
					break;
				case "size" :
					bw.write(queue.size() + "\n");
					break;
				case "empty" :
					if(queue.isEmpty()) {
						bw.write("1\n");
					}else {
						bw.write("0\n");
					}
					break;
				case "front" :
					if(queue.size() == 0) {
						bw.write("-1\n");
					}else {
						bw.write(queue.peek() + "\n");
					}
					break;
				case "back" :
					if(queue.size() == 0) {
						bw.write("-1\n");
					}else {
						bw.write(last + "\n");
					}
					break;
			}
		}
		bw.flush();
	}	
}
