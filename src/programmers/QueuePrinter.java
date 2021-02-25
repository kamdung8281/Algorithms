package programmers;

import java.util.*;

public class QueuePrinter {
	 class doc {
	        int prior, order = 1;
	        boolean flag = false;

	        public doc(int prior){
	            this.prior = prior;
	        }

	        public doc(int prior, boolean flag){
	            this.prior = prior;
	            this.flag = flag;
	        }

	        public void plus(){
	            order++;
	        }


	    }

	    public int solution(int[] priorities, int location) {
	        int temp;
	        Queue<doc> q = new LinkedList<>();

	        for(int i = 0; i<priorities.length;i++)
	            if(i!=location)
	                q.add(new doc(priorities[i]));
	            else
	                q.add(new doc(priorities[i], true));

	        while(true){
	            temp = 0;
	            doc d1 = q.poll();
	            Iterator<doc> iter = q.iterator();

	            while(iter.hasNext()){
	                doc d2 = iter.next();
	                if(d2.prior>=temp)
	                    temp = d2.prior;
	            }
	            if(d1.prior < temp){
	                q.add(d1);
	            } else{
	                if(d1.flag==true){
	                    return d1.order;
	                }
	                Iterator<doc> iter2 = q.iterator();
	                while(iter2.hasNext()){
	                    iter2.next().plus();
	                }
	            }
	        }
	    }
}
