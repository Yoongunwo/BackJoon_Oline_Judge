import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
    	int num = scanner.nextInt();
    	int mod = scanner.nextInt();
    	int[] prefix = new int[num];
    	long[] countModPrefix = new long[mod];
    	
    	prefix[0] = scanner.nextInt()%mod;
    	countModPrefix[prefix[0]]++;
    	
    	for(int i=1; i<prefix.length; i++) {
    		prefix[i] = (prefix[i-1] + scanner.nextInt())%mod;
    		countModPrefix[prefix[i]]++;
    	}
    	
    	long count = 0;
    	
    	count += countModPrefix[0];
   		for(int i=0;i<mod; i++) {
   			count += countModPrefix[i]*(countModPrefix[i]-1)/2;
   	    }
   		System.out.println(count);
    }    
}
