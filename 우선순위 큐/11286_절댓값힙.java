import java.util.Scanner;

public class Main{
    static int[] minHeap;
    static void change(int i, int j){
        int change = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = change;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int numCommand = scanner.nextInt();
        minHeap = new int[100001];
        int curNum = 0;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numCommand; i++){
            int command = scanner.nextInt();
            if(command == 0){
                if(curNum > 0) {
                    sb.append(minHeap[1]).append("\n");
                    minHeap[1] = minHeap[curNum];
                    minHeap[curNum] = 0;
                    curNum--;
                    int compareIndex = 1;
                    while(compareIndex * 2 <= curNum){
                        if(compareIndex * 2 == curNum){
                            if(Math.abs(minHeap[compareIndex]) > Math.abs(minHeap[compareIndex*2])){
                                change(compareIndex, compareIndex*2);
                            }else if(Math.abs(minHeap[compareIndex]) == Math.abs(minHeap[compareIndex*2])){
                                if(minHeap[compareIndex] > minHeap[compareIndex*2]){
                                    change(compareIndex, compareIndex *2);
                                }
                            }
                            break;
                        }else{
                            if(Math.abs(minHeap[compareIndex * 2]) < Math.abs(minHeap[compareIndex * 2 + 1])){
                                if(Math.abs(minHeap[compareIndex * 2]) < Math.abs(minHeap[compareIndex])){
                                    change(compareIndex * 2, compareIndex);
                                }else if(Math.abs(minHeap[compareIndex * 2]) == Math.abs(minHeap[compareIndex])){
                                    if(minHeap[compareIndex] > minHeap[compareIndex*2]){
                                        change(compareIndex, compareIndex *2);
                                    }else break;
                                }else break;
                                compareIndex *= 2;
                            }else if(Math.abs(minHeap[compareIndex * 2]) > Math.abs(minHeap[compareIndex * 2 + 1])){
                                if(Math.abs(minHeap[compareIndex * 2 + 1]) < Math.abs(minHeap[compareIndex])){
                                    change(compareIndex * 2 + 1, compareIndex);
                                }else if(Math.abs(minHeap[compareIndex * 2 + 1]) == Math.abs(minHeap[compareIndex])){
                                    if(minHeap[compareIndex] > minHeap[compareIndex*2 + 1]){
                                        change(compareIndex, compareIndex *2 +1);
                                    }else break;
                                }else break;
                                compareIndex = compareIndex * 2 + 1;
                            }else{
                                if(minHeap[compareIndex * 2] < minHeap[compareIndex * 2 + 1]){
                                    if(Math.abs(minHeap[compareIndex * 2]) < Math.abs(minHeap[compareIndex])){
                                        change(compareIndex * 2, compareIndex);
                                    }else if(Math.abs(minHeap[compareIndex * 2]) == Math.abs(minHeap[compareIndex])){
                                        if(minHeap[compareIndex] > minHeap[compareIndex*2]){
                                            change(compareIndex, compareIndex *2);
                                        }else break;
                                    }else break;
                                    compareIndex *= 2;
                                }else{
                                    if(Math.abs(minHeap[compareIndex * 2 + 1]) < Math.abs(minHeap[compareIndex])){
                                        change(compareIndex * 2 + 1, compareIndex);
                                    }else if(Math.abs(minHeap[compareIndex * 2 + 1]) == Math.abs(minHeap[compareIndex])){
                                        if(minHeap[compareIndex] > minHeap[compareIndex*2 + 1]){
                                            change(compareIndex, compareIndex *2+1);
                                        }else break;
                                    }else break;
                                    compareIndex = compareIndex * 2 + 1;
                                }
                            }
                        }
                    }
                }
                else{
                    sb.append("0\n");
                }
            }
            else{
                curNum++;
                minHeap[curNum] = command;
                int compareIndex = curNum;
                while(compareIndex > 1){
                    if(Math.abs(minHeap[compareIndex]) < Math.abs(minHeap[compareIndex/2])){
                        change(compareIndex, compareIndex/2);
                        compareIndex /= 2;
                    }else if(Math.abs(minHeap[compareIndex]) == Math.abs(minHeap[compareIndex/2])){
                        if(minHeap[compareIndex] < minHeap[compareIndex/2]){
                            change(compareIndex, compareIndex/2);
                            compareIndex /= 2;
                        }else break;
                    }
                    else break;
                }
            }
        }
        System.out.print(sb);
    }
}
