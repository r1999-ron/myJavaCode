public class PonnyDonnyMaximumElement {
	public static void main(String[] args) {
		int[] A = { 2, 4, 3, 1, 5 };
		int B = 3;
		int maxDistinctModels = solve(A, B);
		System.out.println(maxDistinctModels);
	}

	public static int solve(int[] A, int B) {
		int count = 0;
		int x = 0;
		// ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] != B) {
				count++;// 1,2,3,4
			}
			if (A[i] > B) {
				x++; // 1,2
			}

		}
		if (count == A.length) {
			System.out.println(-1);
		}
		return x;

	}

}
