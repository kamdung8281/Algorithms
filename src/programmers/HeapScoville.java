package programmers;
import java.util.*;


public class HeapScoville {
	public int solution(int[] scoville, int K) {
		ArrayList<Integer> heap = new ArrayList<>();
		heap.add(0);
		int count = 0;
		int mix = 0;
		for (int i = 0; i < scoville.length; i++) {
			heap.add(scoville[i]);
			int pointer = heap.size() - 1;
			while (pointer > 1 && heap.get(pointer / 2) > heap.get(pointer)) {
				int tmp = heap.get(pointer / 2);
				heap.set(pointer / 2, heap.get(pointer));
				heap.set(pointer, tmp);
				pointer = pointer / 2;
			}
		} // 힙 생성 및 정렬
		if (heap.get(1) >= K) {
			return 0;
		} else {
			while (heap.size() >= 3) {
				mix = heap.get(1);
				heap = delete(heap);
				mix = mix + heap.get(1) * 2;
				heap = delete(heap);
				count++;
				heap.add(mix);
				int pointer = heap.size() - 1;
				while (pointer > 1 && heap.get(pointer / 2) > heap.get(pointer)) {
					int tmp = heap.get(pointer / 2);
					heap.set(pointer / 2, heap.get(pointer));
					heap.set(pointer, tmp);
					pointer = pointer / 2;
				}
				if (heap.get(1) >= K)
					return count;
			}
			return -1;
		}
	}

	public ArrayList<Integer> delete(ArrayList<Integer> argheap) {

		if (argheap.size() - 1 < 1) { // 힙의 사이즈가 0일 때 동작 취소.
			return argheap;
		}

		argheap.set(1, argheap.get(argheap.size() - 1));
		argheap.remove(argheap.size() - 1);

		int pos = 1;
		while ((pos * 2) < argheap.size()) {
			int min = argheap.get(pos * 2);
			int minPos = pos * 2;

			if (((pos * 2 + 1) < argheap.size()) && min > argheap.get(pos * 2 + 1)) {
				min = argheap.get(pos * 2 + 1);
				minPos = pos * 2 + 1;
			}

			if (argheap.get(pos) < min)
				break;

			int tmp = argheap.get(pos);
			argheap.set(pos, argheap.get(minPos));
			argheap.set(minPos, tmp);
			pos = minPos;
		}

		return argheap;
	}

}
