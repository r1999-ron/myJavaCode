package com.ronak.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PartitionLabel {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter s: ");
			String s = sc.nextLine();
			List<Integer> result = partitionLabels(s);
			System.out.println("Result  is: " + result);
		}
	}

	private static List<Integer> partitionLabels(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map.put(ch, i);
		}
		List<Integer> ans = new ArrayList<>();
		int prev = -1;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			max = Math.max(max, map.get(ch));
			if (max == i) {
				ans.add(max - prev);
				prev = max;
			}

		}
		return ans;
	}
}
