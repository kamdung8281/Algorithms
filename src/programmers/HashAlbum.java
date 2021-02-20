package programmers;

import java.util.*;

public class HashAlbum {
	public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
		HashMap<String, Integer> hm = new HashMap<>();
		HashMap<Integer, Integer> hm2 = new HashMap<>();
		for (int i = 0; i < genres.length; i++)
			hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
		List<String> keySetList = new ArrayList<>(hm.keySet());
		Collections.sort(keySetList, (o1, o2) -> (hm.get(o2).compareTo(hm.get(o1))));
		for (String key : keySetList) {
			for (int i = 0; i < genres.length; i++) {
				if (genres[i].equals(key)) {
						hm2.put(i, plays[i]);
				}
			}
			List<Integer> list = new ArrayList<>(hm2.keySet());
			Collections.sort(list, new Comparator<Object>() {
				public int compare(Object o1, Object o2) {
					Object v1 = hm2.get(o1);
					Object v2 = hm2.get(o2);
					if ((int) v1 < (int) v2) { // 재생횟수 내림차
						return 1;
					} else if ((int) v1 > (int) v2){
                        return -1;
                    } else return 0;
                }
			});
			int flag = 2;
			for (Integer key2 : list) {
				answer.add(key2);
				flag--;
				if (flag == 0) break; // 장르당 두 곡
			}
			hm2.clear();
		}
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}

/*
 * public class Solution { public class Music implements Comparable<Music> {
 * 
 * private int played; private int id; private String genre;
 * 
 * public Music(String genre, int played, int id) { this.genre = genre;
 * this.played = played; this.id = id; }
 * 
 * @Override public int compareTo(Music other) { if (this.played ==
 * other.played) return this.id - other.id; return other.played - this.played; }
 * 
 * public String getGenre() { return genre; } }
 * 
 * public int[] solution(String[] genres, int[] plays) { return
 * IntStream.range(0, genres.length).mapToObj(i -> new Music(genres[i],
 * plays[i], i))
 * .collect(Collectors.groupingBy(Music::getGenre)).entrySet().stream()
 * .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue())) .flatMap(x ->
 * x.getValue().stream().sorted().limit(2)).mapToInt(x -> x.id).toArray(); }
 * 
 * private int sum(List<Music> value) { int answer = 0; for (Music music :
 * value) { answer += music.played; } return answer; } }
 */
