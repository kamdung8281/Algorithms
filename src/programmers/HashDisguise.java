package programmers;
import java.util.*;


public class HashDisguise {
	public int solution(String[][] clothes) {
	    HashMap<String, Integer> hm = new HashMap<>();
	    for(int i=0;i<clothes.length;i++)
	        hm.put(clothes[i][1],hm.getOrDefault(clothes[i][1], 0)+1);
	    int answer = 1;
	    Set<String> keys = hm.keySet();
	    
	    for(String key : keys)
	        answer *= hm.get(key)+1;
	    
	    return answer-1;   
	    
//	    return Arrays.stream(clothes)
//        .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
//        .values()
//        .stream()
//        .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
	}
}