import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		scanner.nextLine();
		
		for(int i=0; i<num; i++) {
			String str = scanner.nextLine();
			int a = 0;
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == '(') a++;
				else a--;
				if(a < 0) {
					break;
				}
			}
			if( a==0) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
