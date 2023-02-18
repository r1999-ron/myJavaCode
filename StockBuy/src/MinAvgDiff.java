package com.ronak.leetcode.problems;

public class MinAvgDiff {

	public static void main(String[] args) {

		int[] nums = { 2, 5, 3, 9, 5, 3 };
		int maxi = Integer.MAX_VALUE;
		int res = 0;
		int n = nums.length;
		long total = 0;
		long sum = 0;
		for (int x : nums) {
			total += x;

		}
		for (int i = 0; i < n - 1; i++) {
			sum += nums[i];
			long curr = Math.abs(sum / (i + 1) - (total - sum) / (n - i - 1));

			if (curr < maxi) {
				maxi = (int) curr;
				res = i;
			}
		}
		int result = maxi > total / n ? n - 1 : res;
		System.out.println(result);
	}

}
