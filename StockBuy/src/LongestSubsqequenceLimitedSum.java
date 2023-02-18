import java.util.Arrays;

public class LongestSubsqequenceLimitedSum {
	public static void main(String[] args) {
		int[] nums = { 4, 5, 2, 1 }; // 1,2,4,5
		int[] queries = { 3, 10, 21 };
		int[] ans = new int[queries.length];
		Arrays.sort(nums);
		for (int i = 0; i < queries.length; i++) {
			ans[i] = numOfElementsLessThan(nums, queries[i]);
			System.out.println(ans[i]);
		}
	}

	private static int numOfElementsLessThan(int[] nums, int query) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > query)
				return i;

		}
		return nums.length;
	}

}
