import java.util.HashSet;

public class SubArrayZeroSum {
	public static void main(String[] args) {
		int[] A = { 1, -1 };
		HashSet<Integer> set = new HashSet<>();
		set.add(0);
		int sum = 0;
		for (int i : A) {
			sum += i;
			if (set.contains(sum)) {
				System.out.println(1);
			}
			set.add(sum);
		}
		System.out.println(0);
	}

}
