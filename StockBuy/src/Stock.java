
public class Stock {

	public static void main(String[] args) {
		int[] prices = { 2, 3, 15, 5, 7 };
		System.out.printf("The maximum profit is %s", getMaxProfit(prices));
	}

	public static int getMaxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int price : prices) {
			if (price < min) {
				min = price;
			}
			maxProfit = Math.max(maxProfit, price - min);
		}
		return maxProfit;
	}

}
