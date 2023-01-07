import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int num = scanner.nextInt();
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		while(num-- > 0) {
			String command = scanner.next();
			if(command.equals("push_back")) {
				int x = scanner.nextInt();
				deque.addLast(x);
			}else if(command.equals("push_front")) {
				int x = scanner.nextInt();
				deque.addFirst(x);
			}else if(command.equals("pop_front")) {
				Integer x = deque.pollFirst();
				sb.append((x == null) ? -1 : x).append("\n");
				
			}else if(command.equals("pop_back")) {
				Integer x = deque.pollLast();
				sb.append(x== null ? -1 : x).append("\n");
			
			}else if(command.equals("size")) {
				sb.append(deque.size()).append("\n");
			
			}else if(command.equals("empty")) {
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
			
			}else if(command.equals("front")) {
				Integer x = deque.peekFirst();
				sb.append(x == null ? -1 : x).append("\n");
			
			}else if(command.equals("back")) {
				Integer x = deque.peekLast();
				sb.append(x == null ? -1 : x).append("\n");
			}
		}
		System.out.println(sb);
		
	}
}
