import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.nextLine();
		
		int sum = 0;
		int store = 0;
		int num = 0;
		int count = 0;
		boolean flag = false;
		for(int i=0; i<str.length(); i++) {
			
			if(str.charAt(i)=='-') {
				store += num;
				if(flag) {
					sum -= store;
				}else {
					sum += store;
				}
				num = 0;
				count = 0;
				store = 0;
				flag = true;
			}else if(str.charAt(i) == '+') {
				store += num;
				num = 0;
				count = 0;
			}else {
				num *= 10;
				num += (str.charAt(i)-48);
				count++;
			}
		}
		store += num;
		if(flag == true) {
			sum -= store;
		}else {
			sum += store;
		}
		System.out.print(sum);
	}
}
