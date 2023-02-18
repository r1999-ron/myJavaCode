package com.ronak.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArrayCount {

	public static void main(String[] args) {
		int[] arr = { 1, 2 };

		Map<Integer, Integer> freq = new HashMap<>();
		for (int a : arr) {
			freq.put(a, freq.getOrDefault(a, 0) + 1);// {1=3,2=2,3=1}
		}
		List<Integer> arrayList = new ArrayList<>();
		Iterator<Map.Entry<Integer, Integer>> iterator = freq.entrySet().iterator();
		while (iterator.hasNext()) {
			int v = iterator.next().getValue();// 3,2,1
			if (arrayList.contains(v)) {
				System.out.println(false);
			} else {
				arrayList.add(v);// [3,2,1]
			}
		}
		System.out.println(true);
	}
}
