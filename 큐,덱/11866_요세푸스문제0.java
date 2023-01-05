import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		int count = 0;
		sb.append("<");
		while(queue.size() != 0) {
			count++;
			int a = queue.poll();
			if(count == k) {
				sb.append(a);
				count = 0;
				if(queue.size() != 0)
					sb.append(", ");
			}else {
				queue.add(a);
			}
		}
		sb.append(">");
		System.out.print(sb);
	}
}
