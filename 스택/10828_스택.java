import java.util.Scanner;
import java.util.Vector;

public class Main{
	static Vector<Integer> stack;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.nextLine();
		
		stack = new Vector<Integer>();
		sb = new StringBuilder();
		
		while(num-- >0) {
			String[] command = scanner.nextLine().split(" ");
			switch(command[0]) {
				case "push" :
					push(Integer.valueOf(command[1]));
					break;
				case "pop" :
					pop();
					sb.append("\n");
					break;
				case "size" :
					size();
					sb.append("\n");
					break;
				case "empty" :
					isEmpty();
					sb.append("\n");
					break;
				case "top" :
					top();
					sb.append("\n");
					break;
			}
		}
		System.out.print(sb);
	}
	static void push(int number) {
		stack.add(number);
	}
	static void pop() {
		if(stack.size() > 0) {
			sb.append(stack.get(stack.size()-1));
			stack.remove(stack.size()-1);
		}else {
			sb.append(-1);
		}
	}
	
	static void size() {
		sb.append(stack.size());
	}
	static void isEmpty() {
		if(stack.isEmpty()) {
			sb.append(1);
		}else {
			sb.append(0);
		}
	}
	static void top() {
		if(stack.size() > 0) {
			sb.append(stack.get(stack.size()-1));
		}
		else {
			sb.append(-1);
		}
	}
}
