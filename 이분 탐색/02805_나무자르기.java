import java.util.Scanner;

public class Main{
    static int[] treeLength;
    static int needLength;
    static int binarySearch(int l, int h){
        if(h < l) return (h+l)/2;

        long mid = (long)(h+l)/2;

        long sum = 0;
        for(int i : treeLength){
            sum += (i - mid) > 0 ? i -mid : 0;
        }
        if(sum < needLength){
            return binarySearch(l, (int)mid-1);
        }else {
            return binarySearch((int)mid+1, h);
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int numTree = scanner.nextInt();
        needLength = scanner.nextInt();

        scanner.nextLine();

        String str = scanner.nextLine();
        String[] strArray = str.split(" ");

        treeLength = new int[strArray.length];
        int maxLength = 0;
        for(int i=0; i<treeLength.length; i++){
            treeLength[i] = Integer.parseInt(strArray[i]);
            maxLength = Math.max(maxLength, treeLength[i]);
        }
        System.out.print(binarySearch(0, maxLength));
    }
}
