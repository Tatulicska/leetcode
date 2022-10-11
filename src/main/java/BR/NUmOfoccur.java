package BR;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.xml.stream.events.Characters;

public class NUmOfoccur {

  public static void main(String[] args) {
	String input = "21345253193";

	System.out.println(solve(input));
  }

  private static List<Integer> solve(String input) {
	Map<Integer, Integer> map = new LinkedHashMap<>();
	for (int i = 0; i < input.length(); i++) {
	  map.merge(Character.getNumericValue(input.charAt(i)), 1, Integer::sum);
	}

	Comparator<Map.Entry<Integer, Integer>> byValue = Map.Entry.comparingByValue();
	Comparator<Map.Entry<Integer, Integer>> byKey = Map.Entry.comparingByKey();

	return map
		.entrySet().stream()
		.sorted(byValue.thenComparing(byKey))
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());
//	return input.chars()
//		.mapToObj(Character::getNumericValue)
//		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//		.entrySet()
//		.stream()
//		.sorted(Comparator.comparingInt(e -> e.getValue().intValue()))
//		.map(Map.Entry::getKey).collect(Collectors.toList());
  }
}
