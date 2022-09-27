import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        StringBuffer sb = new StringBuffer();
        int z = 0;
        int a_length = a.length();
        int b_length = b.length();
        if( a_length > b_length){
            while( b_length-- > 0){
                int c = a.charAt(--a_length) + b.charAt(b_length) - 96 + z;
                if( c > 9 ) z = 1; else z = 0;
                sb.append(c%10);
            }
            while( a_length-- > 0){
                int c = a.charAt(a_length) - 48 + z;
                if (c > 9) z = 1; else z = 0;
                sb.append(c%10);
            }
        }else{
            while( a_length-- > 0){
                int c = a.charAt(a_length) + b.charAt(--b_length) - 96 +z;
                if( c > 9 ) z = 1; else z = 0;
                sb.append(c%10);
            }
            while( b_length-- > 0){
                int c = b.charAt(b_length) - 48 + z;
                if( c>9) z = 1; else z= 0;
                sb.append(c%10);
            }
        }
        if(z == 1) sb.append(z);
        sb.reverse();
        System.out.print(sb);
    }
}
