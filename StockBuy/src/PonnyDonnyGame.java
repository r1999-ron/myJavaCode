public class PonnyDonnyGame {

	public static void main(String[] args) {
		int[] A = { 2, 1, 3 };
		int area = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
				area += A[i] - Math.min(A[i - 1], A[i + 1]);
			}
		}

		System.out.println("Total area of hills: " + area);
	}

}
