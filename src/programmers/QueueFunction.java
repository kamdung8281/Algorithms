package programmers;

import java.util.*;

public class QueueFunction {
	 class pro{
	        int progs, speed;
	        public pro(int progs, int speed){
	            this.progs = progs;
	            this.speed = speed;
	        }
	        public void work(){
	            progs += speed;
	        }
	    }

	    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
	        ArrayList<Integer> answer = new ArrayList<>();
	        int len = progresses.length;
	        int temp = 0;
	        boolean flag = false;
	        Queue<pro> q = new LinkedList<>();
	        for(int i = 0; i<len ; i++) q.add(new pro(progresses[i], speeds[i]));
	        while(true){
	            temp = 0;
	            flag = false;
	            Iterator<pro> iter = q.iterator();
	            while(iter.hasNext()){
	                pro p = iter.next();
	                p.work();
	            }
	            while(!q.isEmpty()){
	                pro p = q.peek();
	                if(p.progs>=100){
	                    q.poll();
	                    temp++;
	                    flag = true;
	                }else
	                    break;
	            }
	            if(flag)
	                answer.add(temp);
	            if(q.isEmpty())
	                break;
	        }
	        return answer;
	    }
}
