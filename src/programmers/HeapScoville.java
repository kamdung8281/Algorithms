package programmers;

import java.util.*;

//9. HeapScoville				https://programmers.co.kr/learn/courses/30/lessons/42626
public class HeapScoville {
	public int solution(int[] scoville, int K) {
		ArrayList<Integer> heap = new ArrayList<>();
		heap.add(0);

		for (int i = 0; i < scoville.length; i++) {
			heap.add(scoville[i]);
			heap = heapify(heap);
		}

		if (heap.get(1) >= K)
			return 0;
		else
			return mix(heap, K);

	}

	public int mix(ArrayList<Integer> heap, int K) {
		int count = 0;
		int mix = 0;
		while (heap.size() >= 3) {
			mix = heap.get(1);
			heap = delete(heap);
			mix = mix + heap.get(1) * 2;
			heap = delete(heap);
			count++;
			heap.add(mix);
			int pointer = heap.size() - 1;
			heap = heapify(heap);
			if (heap.get(1) >= K)
				return count;
		}
		return -1;

	}

	public ArrayList<Integer> heapify(ArrayList<Integer> heap) {
		int tmp;
		int pointer = heap.size() - 1;
		while (pointer > 1 && heap.get(pointer / 2) > heap.get(pointer)) {
			tmp = heap.get(pointer / 2);
			heap.set(pointer / 2, heap.get(pointer));
			heap.set(pointer, tmp);
			pointer = pointer / 2;
		}
		return heap;

	}

	public ArrayList<Integer> delete(ArrayList<Integer> heap) {

		if (heap.size() - 1 < 1) {
			return heap;
		}

		heap.set(1, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);

		int pos = 1;
		while ((pos * 2) < heap.size()) {
			int min = heap.get(pos * 2);
			int minPos = pos * 2;

			if (((pos * 2 + 1) < heap.size()) && min > heap.get(pos * 2 + 1)) {
				min = heap.get(pos * 2 + 1);
				minPos = pos * 2 + 1;
			}

			if (heap.get(pos) < min)
				break;

			int tmp = heap.get(pos);
			heap.set(pos, heap.get(minPos));
			heap.set(minPos, tmp);
			pos = minPos;
		}

		return heap;
	}

}
