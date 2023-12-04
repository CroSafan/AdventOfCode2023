package com.crosafan.aoc;

import java.util.List;

public class Day4A {

	public int solve(List<String> allLines) {
		int sum = 0;
		for (String line : allLines) {
			String[] card = line.split("[0-9]: ");
			String[] nums = card[1].split(" \\| ");

			int numWins = 0;
			for (String winning : nums[0].split(" ")) {
				for (String mine : nums[1].split(" ")) {
					if (winning.equals(mine) && !winning.isEmpty() && !mine.isEmpty()) {
						numWins++;

					}

				}
			}
			int points = 0;
			for (int i = 0; i < numWins; i++) {
				if (points == 0) {
					points = 1;
				} else {
					points = 2 * points;
				}
			}
			sum += points;

		}

		return sum;
	}

}
