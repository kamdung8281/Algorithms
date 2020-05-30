package programmers;

import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		
		// Stack/Queue
		// 1. Towers				https://programmers.co.kr/learn/courses/30/lessons/42588
		Towers towers = new Towers();
		int[] towersa = {6,9,5,7,4};
		System.out.println(Arrays.toString(towers.solution(towersa)));
		
		
		// 2. Trucks 				https://programmers.co.kr/learn/courses/30/lessons/42583
		Trucks trucks = new Trucks();
		int[] trucksa = {7,4,5,6};
		System.out.println(trucks.solution(2, 11, trucksa));
		
		// 3. HashMarathon			https://programmers.co.kr/learn/courses/30/lessons/42576
		HashMarathon hm = new HashMarathon();
		String[] participant = {"leo","kiki","eden"};
		String[] completion = {"eden", "kiki"};
		System.out.println(hm.solution(participant, completion));
	}

}
