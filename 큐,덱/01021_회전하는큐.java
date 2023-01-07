import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main{
	static Deque<Integer> deque;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int queSize = scanner.nextInt();
		int extractNum = scanner.nextInt();
		
		deque = new ArrayDeque<>();
		for(int i=0; i<queSize; i++) {
			deque.addLast(i+1);
		}
		int count = 0;
		while(extractNum-- > 0) {
			int num = scanner.nextInt();
			int peekNum = deque.peek();
			
			Object[] arr= deque.toArray();
			int index;
			for(index=0; index<arr.length; index++) {
				if(arr[index].equals(num)) break;
			}
			if(index < (arr.length - index)) {
				count += index;
				moveLeft(num);
				
			}else {
				count += arr.length - index;
				moveRight(num);
			}
		}
		System.out.print(count);
	}
	static void moveLeft(int num) {
		while(deque.peek() != num) {
			int a = deque.pollFirst();
			deque.addLast(a);
		}
		deque.poll();
	}
	static void moveRight(int num) {
		while(deque.peek() != num) {
			int a= deque.pollLast();
			deque.addFirst(a);
		}
		deque.poll();
	}
}
