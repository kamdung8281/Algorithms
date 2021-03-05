package programmers;

import java.util.*;

//9. HeapScoville				https://programmers.co.kr/learn/courses/30/lessons/42626
public class HeapScoville {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int cnt = 0;
		for (int a : scoville)
			pq.add(a);
		while (pq.peek() < K) {
			if (pq.size() >= 2) {
				pq.add(pq.poll() + pq.poll() * 2);
				cnt++;
			} else
				return -1;
		}
		return cnt;

	}

}
