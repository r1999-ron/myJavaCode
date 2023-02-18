
public class PonnyMaximum {

	public static void main(String[] args) {
		int[] A = { 1, 4, 2, 3 };
		int B = 3;
		int x = 0;
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > B) {
				x++; // 1
			}
			if (A[i] != B) {
				count++; // 1,2,3
			}

		}
		int res = (count == A.length) ? -1 : x;
		System.out.println(res);
	}

}
