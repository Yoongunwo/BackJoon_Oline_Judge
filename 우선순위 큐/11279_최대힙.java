import java.util.Scanner;
import java.util.Vector;

public class Main {
    static Vector<Integer> vec;
    static void erase(){
        int index = 1;
        if(vec.size() == 2){
            vec.remove(1);
            return;
        }
        while(true){
            if(index*2 >  vec.size()-1){
                vec.set(index, 0);
                return;
            }else if(index*2 == vec.size()-1){
                vec.set(index, vec.get(index*2));
                index *= 2;
            }else {
                if (vec.get(index * 2) > vec.get(index * 2 + 1)) {
                    vec.set(index, vec.get(index * 2));
                    index *= 2;
                } else {
                    vec.set(index, vec.get(index * 2 + 1));
                    index = index*2 +1;
                }
            }
        }
    }
    static void sort(){
        int index = vec.size()-1;
        while(index != 1){
            if(vec.get(index) > vec.get(index/2)){
                int temp = vec.get(index);
                vec.set(index, vec.get(index/2));
                vec.set(index/2, temp);
                index /= 2;
            }else{
                return;
            }
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int numCommand = scanner.nextInt();

        vec = new Vector<>();
        vec.add(0);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numCommand; i++){
            int command = scanner.nextInt();

            if(command == 0){
                if(vec.size() == 1){
                    sb.append(0);
                }else{
                    sb.append(vec.get(1));
                    erase();
                }
                sb.append("\n");
            }else{
                vec.add(command);
                sort();
            }
        }
        System.out.print(sb);
    }
}
