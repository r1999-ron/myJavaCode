package com.ronak.leetcode.problems;

import java.util.Scanner;

public class PalindromePermutations {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String phrases = sc.nextLine();

			System.out.println(isPermutationOfPalindrome(phrases));
		}
	}

	private static boolean isPermutationOfPalindrome(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);

	}

	private static boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}

	private static int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;
			}
		}
		return table;
	}

	private static int getCharNumber(char c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}

}
