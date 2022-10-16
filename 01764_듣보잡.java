import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); int m = scanner.nextInt();

        Vector<String> set = new Vector<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(int b=0; b<n+m; b++){
            String a = scanner.nextLine();
            if(map.containsKey(a)){
                map.replace(a, 2);
                set.add(a);
            }else map.put(a, 1);
        }
        Collections.sort(set);
        System.out.println(set.size());
        for (String s : set) System.out.println(s);
    }
}
