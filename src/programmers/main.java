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
		
		// 4. HashDisguise			https://programmers.co.kr/learn/courses/30/lessons/42578
		HashDisguise hd = new HashDisguise();
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(hd.solution(clothes));
		
		// 5. HashAlbum				https://programmers.co.kr/learn/courses/30/lessons/42579
		HashAlbum ha = new HashAlbum();
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		for(Integer a : ha.solution(genres, plays)) System.out.println(a);
	}

}
