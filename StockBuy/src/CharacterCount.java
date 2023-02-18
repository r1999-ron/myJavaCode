package com.ronak.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CharacterCount {

	public static void main(String[] args) {
		String s = "";
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the number of inputs");
			int t = sc.nextInt();
			System.out.println("Enter the strings:-");
			for (int i = 0; i <= t; i++) {
				s = sc.nextLine();
				Map<Character, Integer> characterCount = new HashMap<>();
				for (char ch : s.toCharArray()) {
					characterCount.put(ch, characterCount.getOrDefault(ch, 0) + 1);

				}
				List<Character> characterList = new ArrayList<>(characterCount.keySet());
				Collections.sort(characterList, (ch1, ch2) -> characterCount.get(ch2) - characterCount.get(ch1));
				StringBuilder result = new StringBuilder();
				for (char ch : characterList) {
					int charCount = characterCount.get(ch);
					for (int j = 0; j < charCount; j++) {
						result.append(ch);
					}
				}
				System.out.println(result.toString());
			}
		}
	}
}
