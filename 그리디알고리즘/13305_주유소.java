import java.math.BigInteger;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] distance = new int[num-1];
		long[] price = new long[num-1];
		
		for(int i=0; i<distance.length; i++) {
			distance[i] = scanner.nextInt();
		}
		for(int i=0; i<price.length; i++) {
			price[i] = scanner.nextInt();
		}
		scanner.nextInt();
		
		long cur_price = 1000000000;
		BigInteger biginteger = new BigInteger("0");
		
		for(int i=0; i<distance.length; i++) {
			cur_price = Math.min(cur_price, price[i]);
			biginteger = biginteger.add(BigInteger.valueOf(cur_price * distance[i]));
		}
		System.out.print(biginteger);
	}
}
