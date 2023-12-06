package com.crosafan.aoc.days;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day3B {
//https://adventofcode.com/2023/day/3
	public int solve(List<String> allLines) {
		int sum = 0;

		for (int i = 0; i < allLines.size(); i++) {

			for (int j = 0; j < allLines.get(0).length(); j++) {

				if (allLines.get(i).charAt(j) == '*') {
					ArrayList<Integer> possibleParts = new ArrayList<Integer>();
					for (Neighbour neigbour : getAdjacent(allLines, i, j)) {

						if (isNumber(neigbour.value)) {
							int startIndex = neigbour.getI();
							int endIndex = neigbour.getI() + 1;
							// go left until you reach a non number
							for (int col = neigbour.getJ(); col >= 0; col--) {
								if (isNumber(String.valueOf(allLines.get(neigbour.getI()).charAt(col)))) {
									startIndex = col;
								} else {
									break;
								}
							}
							// go right until you reach a non number

							for (int col = neigbour.getJ(); col < allLines.get(0).length(); col++) {
								if (isNumber(String.valueOf(allLines.get(neigbour.getI()).charAt(col)))) {
									endIndex = col + 1;

								} else {
									break;
								}
							}

							int num = Integer.parseInt(allLines.get(neigbour.getI()).substring(startIndex, endIndex));
							possibleParts.add(num);

						}

					}
					possibleParts = (ArrayList<Integer>) possibleParts.stream().distinct().sorted()
							.collect(Collectors.toList());
					if (possibleParts.size() == 2) {
						sum += (possibleParts.get(0) * possibleParts.get(1));
					}
				}

			}

		}

		return sum;
	}

	public boolean isNumber(String input) {
		return input.matches("[0-9]");
	}


	// Function that returns all adjacent elements
	static List<Neighbour> getAdjacent(List<String> arr, int i, int j) {
		// Size of given 2d array
		int n = arr.size();
		int m = arr.get(0).length();

		// Initialising a array list where adjacent element
		// will be stored
		List<Neighbour> v = new ArrayList<>();

		// Checking for all the possible adjacent positions
		if (isValidPos(i - 1, j - 1, n, m)) {
			Neighbour neighbour = new Neighbour();
			neighbour.setI(i - 1);
			neighbour.setJ(j - 1);
			neighbour.setValue(String.valueOf(arr.get(i - 1).charAt(j - 1)));

			v.add(neighbour);
		}
		if (isValidPos(i - 1, j, n, m)) {
			Neighbour neighbour = new Neighbour();
			neighbour.setI(i - 1);
			neighbour.setJ(j);
			neighbour.setValue(String.valueOf(arr.get(i - 1).charAt(j)));

			v.add(neighbour);

		}
		if (isValidPos(i - 1, j + 1, n, m)) {

			Neighbour neighbour = new Neighbour();
			neighbour.setI(i - 1);
			neighbour.setJ(j + 1);
			neighbour.setValue(String.valueOf(arr.get(i - 1).charAt(j + 1)));

			v.add(neighbour);

		}
		if (isValidPos(i, j - 1, n, m)) {

			Neighbour neighbour = new Neighbour();
			neighbour.setI(i);
			neighbour.setJ(j - 1);
			neighbour.setValue(String.valueOf(arr.get(i).charAt(j - 1)));

			v.add(neighbour);

		}
		if (isValidPos(i, j + 1, n, m)) {

			Neighbour neighbour = new Neighbour();
			neighbour.setI(i);
			neighbour.setJ(j + 1);
			neighbour.setValue(String.valueOf(arr.get(i).charAt(j + 1)));

			v.add(neighbour);

		}
		if (isValidPos(i + 1, j - 1, n, m)) {

			Neighbour neighbour = new Neighbour();
			neighbour.setI(i + 1);
			neighbour.setJ(j - 1);
			neighbour.setValue(String.valueOf(arr.get(i + 1).charAt(j - 1)));

			v.add(neighbour);

		}
		if (isValidPos(i + 1, j, n, m)) {

			Neighbour neighbour = new Neighbour();
			neighbour.setI(i + 1);
			neighbour.setJ(j);
			neighbour.setValue(String.valueOf(arr.get(i + 1).charAt(j)));

			v.add(neighbour);

		}
		if (isValidPos(i + 1, j + 1, n, m)) {

			Neighbour neighbour = new Neighbour();
			neighbour.setI(i + 1);
			neighbour.setJ(j + 1);
			neighbour.setValue(String.valueOf(arr.get(i + 1).charAt(j + 1)));

			v.add(neighbour);

		}

		// Returning the arraylist
		return v;
	}

	static class Neighbour {
		private int i;
		private int j;
		private String value;

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	static boolean isValidPos(int i, int j, int n, int m) {
		if (i < 0 || j < 0 || i > n - 1 || j > m - 1) {
			return false;
		}
		return true;
	}

}
