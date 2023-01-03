import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String str;
		while(true){
			str = scanner.nextLine();
			if(str.equals(".")) break;
			
			char[] arr = new char[100];
			int arrIndex = 0;
			boolean result = true;
			
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == '(') {
					arr[arrIndex++] = '(';
				}else if(str.charAt(i) == '[') {
					arr[arrIndex++] = '[';
				}
				else if(str.charAt(i) == ')'){
					if(arrIndex <= 0) {
						result = false;
						break;
					}
					if(arr[arrIndex-1] != '(') {
						result = false;
						break;
					}else {
						arrIndex--;
					}
				}else if(str.charAt(i) == ']') {
					if(arrIndex <= 0) {
						result = false;
						break;
					}
					if(arr[arrIndex-1] != '[') {
						result = false;
						break;
					}else {
						arrIndex--;
					}
				}
			}
			if(result && arrIndex == 0) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
