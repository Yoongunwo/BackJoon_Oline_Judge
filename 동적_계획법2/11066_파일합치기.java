import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Main{
    static int[][] dp;
    static void getFileSizes(List<Integer> list, String[] sizes){
        for(int i=0; i<sizes.length; i++){
            list.add(Integer.parseInt(sizes[i]));
        }
    }
    static List<Integer> getPrefixSum(List<Integer> list){
        List<Integer> prefixSum = new Vector<>();
        prefixSum.add(0);
        for(int i=0; i<list.size(); i++){
            int a = prefixSum.get(i) + list.get(i);
            prefixSum.add(a);
        }
        return prefixSum;
    }

    static int Mydp(List<Integer> prefixSum, int l, int h){
        if(h - l <= 1) return 0;
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        int diffIndex = l;
        for(int i=l+1; i<=h; i++){
            int diff = (prefixSum.get(i) - prefixSum.get(l)) - (prefixSum.get(h) - prefixSum.get(i));
            diff = Math.abs(diff);
            if(diff < minDiff){
                minDiff = diff;
                diffIndex = i;
                result = (prefixSum.get(i) - prefixSum.get(l)) + (prefixSum.get(h) - prefixSum.get(i));
            }
        }
        System.out.println((prefixSum.get(diffIndex) - prefixSum.get(l))
                + " + " + (prefixSum.get(h) - prefixSum.get(diffIndex) + " = " + result));

        result += Mydp(prefixSum, l, diffIndex);
        result += Mydp(prefixSum, diffIndex, h);
        return result;
    }

    static int dp(List<Integer> prefixSum, int l, int h ){
        if(h - l <= 0) return 0;
        if(dp[l][h] != ) return dp[l][h];
        dp[l][h] = prefixSum.get(h+1) - prefixSum.get(l);
        int result = Integer.MAX_VALUE;
        for(int i = l; i<h; i++){
            dp[l][i] = dp(prefixSum, l, i);
            dp[i+1][h] = dp(prefixSum, i+1, h);
            result = Math.min(result, dp[l][i] + dp[i+1][h]);
        }
        dp[l][h] += result;
        return dp[l][h];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int textCase = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder();

        while(textCase-- > 0){
            int numFile = Integer.parseInt(scanner.nextLine());
            String[] sizes = scanner.nextLine().split(" ");

            List<Integer> list = new Vector<>();

            getFileSizes(list, sizes);
            List<Integer> prefixSum = getPrefixSum(list);

            dp = new int[list.size()][list.size()];

            int result = dp(prefixSum,0, list.size()-1);

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
