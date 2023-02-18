public class ZeroSubarraySum {
	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		int res_sum = 0;
		int sum = 0;
		for (int i : A) {
			sum += i;
			if (sum == res_sum) {
				System.out.println(1);
			}

		}
		System.out.println(0);
	}

}
