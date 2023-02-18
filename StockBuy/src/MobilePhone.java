public class MobilePhone {

	public static void main(String[] args) {
		int[] prices = { 23, 36, 58, 59 };
		int[] money = { 3, 207, 62, 654, 939, 680, 760 };
		int[] maxDistinctModels = solve(prices, money);
		System.out.println(maxDistinctModels);
	}

	public static int[] solve(int[] prices, int[] money) {
		int[] prefixSum = new int[prices.length];
		int[] ans = new int[money.length];
		prefixSum[0] = prices[0];

		for (int i = 0; i < prices.length - 1; i++) {
			try {
				prefixSum[i + 1] = prefixSum[i] + prices[i + 1];
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		for (int i = 0; i < money.length; i++) {
			int l = 0;
			int r = prices.length - 1;
			int count = 0;
			while (l <= r) {
				int m = (l + r) / 2;

				if (prefixSum[m] == money[i]) {
					count = m + 1;
					break;
				} else if (prefixSum[m] > money[i]) {
					r = m - 1;
				} else {
					l = m + 1;
					count = m + 1;

				}
			}
			ans[i] = count;
			System.out.println(ans[i]);
		}
		return ans;
	}
}
