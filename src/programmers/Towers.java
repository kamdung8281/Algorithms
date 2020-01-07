package programmers;

import java.util.Stack;

public class Towers {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		Stack<Integer> stk = new Stack<Integer>();
		Stack<Integer> temp = new Stack<Integer>();
		int a = 0;
		for (int i = 0; i < heights.length; i++) {
			stk.push(heights[i]);
			temp.addAll(stk);
			a = (int) temp.pop();
			while (!temp.empty()) {
				if (a < (int) temp.pop()) {
					answer[i] = temp.size() + 1;
					break;
				}
			}
			temp.clear();
		}
		return answer;
	}
}
