import java.util.HashMap;

public class PairSum {
	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 2, 1 };
		int B = 5;
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : A) {
			if (map.containsKey(B - i)) {
				count += map.get(B - i);
			}
			if (i == B - i && map.get(i) != null && map.get(i) > 1) {
				count--;
			}
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		System.out.println(count);
	}

}
