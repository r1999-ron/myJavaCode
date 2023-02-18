package com.ronak.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PalindromePermutationHashMap {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String phrases = sc.nextLine();

			System.out.println(isPermutationOfPalindrome(phrases.toLowerCase().replaceAll("\\s+", "")));
		}
	}

	@SuppressWarnings("unused")
	private static boolean isPermutationOfPalindrome(String phrase) {
		System.out.println("After transformation the string becomes: - " + phrase);
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < phrase.length(); i++) {
			map.put(phrase.charAt(i), map.getOrDefault(phrase.charAt(i), 0) + 1);
		}
		int count = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			Character key = entry.getKey();
			Integer value = entry.getValue();
			count += value % 2;
		}
		return count <= 1;

	}

}
