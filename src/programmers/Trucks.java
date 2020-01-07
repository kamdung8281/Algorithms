package programmers;

import java.util.ArrayDeque;

class Trucks {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridgeweight = 0;
        
        ArrayDeque<Integer> waiting = new ArrayDeque<Integer>();
        for(int l = 0; l<truck_weights.length;l++) waiting.offer(truck_weights[l]);
        ArrayDeque<Integer> passing = new ArrayDeque<Integer>();
        ArrayDeque<Integer> passed = new ArrayDeque<Integer>();
        
        while(passed.size()!=truck_weights.length){
            answer++;
            if(passing.size()==bridge_length) {
                bridgeweight -= passing.peek();
                if(passing.peek()!=0){
                    passed.offer(passing.poll());
                }else passing.poll();
            }
            if(!waiting.isEmpty()){
                if((bridgeweight + waiting.peek()) <= weight){
                passing.offer(waiting.poll());
                bridgeweight += passing.getLast();
                }else{
                    passing.offer(0);
                }
            }else{
                passing.offer(0);
            }
        }
        return answer;
    }
}