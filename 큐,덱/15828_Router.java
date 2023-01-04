import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		int size = scanner.nextInt();
		
		int input;
		while(true) {
			input = scanner.nextInt();
			if(input == -1) break;
			else if(input > 0) {
				if(queue.size() >= size) {
					continue;
				}
				queue.add(input);
			}else {
				queue.poll();
			}
			
		}
		if(queue.size() == 0) {
			System.out.print("empty");
		}else {
			Iterator<Integer> it = queue.iterator();
			while(it.hasNext()) {
				System.out.print(it.next() +" ");
			}
		}
	}
}
