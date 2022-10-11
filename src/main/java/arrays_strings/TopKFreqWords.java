package arrays_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Given an array of strings words and an integer k, return the k most frequent strings.
//
//	Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
//

public class TopKFreqWords {

  public static void main(String[] args) {
	System.out.println(7/2);
	System.out.println(topKFrequent(new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
  }

  public static List<String> topKFrequent(String[] words, int k) {
	Map<String, Integer> map = new HashMap<>();
	for(String s: words){
	  map.put(s, map.getOrDefault(s,0)+1);
	}
	List<String> candidates = new ArrayList<>(map.keySet());
	candidates.sort(
		(w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
	return candidates.subList(0,k);
  }
}
