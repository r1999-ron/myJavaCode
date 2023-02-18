package com.ronak.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
		CourseSchedule sol = new CourseSchedule();
		System.out.println(sol.canFinish(numCourses, prerequisites));
	}

	private boolean canFinish(int numOfCourses, int[][] prerequisites) {
		List<List<Integer>> adjacencyList = new ArrayList<>(numOfCourses);
		System.out.println("Adjacency list here is: " + adjacencyList);
		for (int i = 0; i < numOfCourses; i++) {
			adjacencyList.add(new ArrayList<>());
			System.out.println("Adding in the list: " + adjacencyList);
		}
		for (int[] prerequisite : prerequisites) {
			adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
		}
		int[] visited = new int[numOfCourses];
		for (int i = 0; i < numOfCourses; i++) {
			if (!dfs(i, adjacencyList, visited)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int current, List<List<Integer>> adjacencyList, int[] visited) {
		// 0: unvisited, 1: visiting, 2: visited
		if (visited[current] == 1) {
			return false;
		}
		if (visited[current] == 2) {
			return true;
		}
		visited[current] = 1;
		for (int neighbour : adjacencyList.get(current)) {
			if (!dfs(neighbour, adjacencyList, visited)) {
				return false;
			}
		}
		visited[current] = 2;
		return true;
	}

}
