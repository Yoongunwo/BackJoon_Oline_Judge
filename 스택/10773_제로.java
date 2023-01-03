import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		Vector<Integer> vec = new Vector<>();
		
		for(int i=0; i<num; i++) {
			int a = scanner.nextInt();
			if(a == 0) {
				vec.remove(vec.size()-1);
			}else {
				vec.add(a);
			}
		}
		long sum = 0;
		Iterator<Integer> it = vec.iterator();
		while(it.hasNext())
			sum += it.next();
		System.out.println(sum);
	}
}
