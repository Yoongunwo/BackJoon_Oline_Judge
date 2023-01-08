import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int testNum = scanner.nextInt();
		StringBuilder sb = new StringBuilder();
		while(testNum-- > 0) {
			char[] commands = scanner.next().toCharArray();
			int arrNum = scanner.nextInt();
			String[] numArr = scanner.next().split("\\[|,|\\]");
			
			Deque<Integer> deque = new ArrayDeque<>();
			for(int i=1; i<numArr.length; i++) {
				deque.addLast(Integer.valueOf(numArr[i]));
			}
			
			boolean flag = true;
			int i = 0;
			for(; i<commands.length; i++) {
				if(commands[i] == 'R') {
					flag = !flag;
				}else {
					if(deque.size() == 0) {
						sb.append("error\n");
						break;
					}
					if(flag) {
						deque.pollFirst();
					}else {
						deque.pollLast();
					}
				}
			}
			if(i == commands.length) {
				sb.append("[");
				if (deque.size()>0) {
					if(flag) {
						while(deque.size() > 1) {
							sb.append(deque.poll()).append(",");
						}
						sb.append(deque.poll());
					}else {
						while(deque.size() > 1) {
							sb.append(deque.pollLast()).append(",");
						}
						sb.append(deque.poll());
					}
				}
				sb.append("]\n");
			}
		}
		System.out.print(sb);
	}
}
