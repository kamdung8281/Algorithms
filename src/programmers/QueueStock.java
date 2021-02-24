package programmers;

import java.util.*;


public class QueueStock {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];        
        int temp = 0;
        int temp2 = 0;
        Queue<Integer> q = new LinkedList<>();  for(int a : prices) q.add(a);
        for(int i = 0; i<prices.length-1;i++){
            temp = q.poll();
            for(int j = i+1; j< prices.length ; j++){
                answer[i]++;
                if(temp - prices[j] > 0){
                    break;
                }
            }
        }
        return answer;
    }
}
