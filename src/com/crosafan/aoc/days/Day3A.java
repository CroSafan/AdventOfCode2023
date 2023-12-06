package com.crosafan.aoc.days;

import java.util.ArrayList;
import java.util.List;

public class Day3A {
//https://adventofcode.com/2023/day/3
	public int solve(List<String> allLines) {
		int sum = 0;

		for (int i = 0; i < allLines.size(); i++) {
			String num = "";

			boolean isPart = false;

			for (int j = 0; j < allLines.get(0).length(); j++) {

				if (isNumber(String.valueOf(allLines.get(i).charAt(j)))) {
					num = num + allLines.get(i).charAt(j);

					List<String> adjacent = getAdjacent(allLines, i, j);

					for (String neighnour : adjacent) {

						if (isPart(neighnour)) {
							isPart = true;
						}

					}

					// special case if we are at the last characted
					if (!num.isEmpty() && j == allLines.get(i).length() - 1) {

						if (isPart) {
							sum += Integer.parseInt(num);
						}
						num = "";
						isPart = false;

					}

				} else {
					if (!num.isEmpty()) {

						if (isPart) {
							sum += Integer.parseInt(num);
						}

						num = "";
						isPart = false;

					} else {
						num = "";
					}

				}

			}

		}

		return sum;
	}

	public boolean isNumber(String input) {
		return input.matches("[0-9]");
	}

	public boolean isPart(String input) {
		boolean result = true;

		if (isNumber(input)) {
			result = false;
		}

		if (input.equals(".")) {
			result = false;
		}

		return result;
	}

	// Function that returns all adjacent elements
	static List<String> getAdjacent(List<String> arr, int i, int j) {
		// Size of given 2d array
		int n = arr.size();
		int m = arr.get(0).length();

		// Initialising a array list where adjacent element
		// will be stored
		List<String> v = new ArrayList<>();

		// Checking for all the possible adjacent positions
		if (isValidPos(i - 1, j - 1, n, m)) {
			v.add(String.valueOf(arr.get(i - 1).charAt(j - 1)));
		}
		if (isValidPos(i - 1, j, n, m)) {
			v.add(String.valueOf(arr.get(i - 1).charAt(j)));
		}
		if (isValidPos(i - 1, j + 1, n, m)) {
			v.add(String.valueOf(arr.get(i - 1).charAt(j + 1)));
		}
		if (isValidPos(i, j - 1, n, m)) {
			v.add(String.valueOf(arr.get(i).charAt(j - 1)));
		}
		if (isValidPos(i, j + 1, n, m)) {
			v.add(String.valueOf(arr.get(i).charAt(j + 1)));
		}
		if (isValidPos(i + 1, j - 1, n, m)) {
			v.add(String.valueOf(arr.get(i + 1).charAt(j - 1)));
		}
		if (isValidPos(i + 1, j, n, m)) {
			v.add(String.valueOf(arr.get(i + 1).charAt(j)));
		}
		if (isValidPos(i + 1, j + 1, n, m)) {
			v.add(String.valueOf(arr.get(i + 1).charAt(j + 1)));
		}

		// Returning the arraylist
		return v;
	}

	static boolean isValidPos(int i, int j, int n, int m) {
		if (i < 0 || j < 0 || i > n - 1 || j > m - 1) {
			return false;
		}
		return true;
	}

}
