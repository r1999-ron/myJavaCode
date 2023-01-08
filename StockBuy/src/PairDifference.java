import java.util.HashMap;
import java.util.Map;

public class PairDifference {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 4, 2 };
		int k = 3;
		// use a hashmap to store the frequencies of the elements in the array.
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			int count = map.getOrDefault(num, 0);
			map.put(num, count + 1);
		}
		int count = 0;
		// loop through the keys of the map
		for (int key : map.keySet()) {
			int val = map.get(key);
			if (val > 1) {
				count += val * (val - 1) / 2;
			}
			int target = key + k;
			if (map.containsKey(target)) {
				count += val * map.get(target);
				System.out.println("The initial count operation: " + count);
			}
		}
		System.out.println("Count of pairs: " + count);
	}

}
