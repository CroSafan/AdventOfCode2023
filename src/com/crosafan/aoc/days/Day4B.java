package com.crosafan.aoc.days;

import java.util.ArrayList;
import java.util.List;

public class Day4B {

	public int solve(List<String> allLines) {
		int sum = 0;
		ArrayList<int[]> winnings = new ArrayList<int[]>();
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

			winnings.add(new int[] { 1, numWins });
		}

		for (int i = 0; i < winnings.size(); i++) {
			int numOfCards = winnings.get(i)[0];
			int steps = winnings.get(i)[1];
			for (int j = i + 1; j < i + steps + 1; j++) {
				winnings.get(j)[0] = winnings.get(j)[0] + (1 * numOfCards);
			}
		}

		for (int[] winning : winnings) {
			sum += winning[0];
		}

		return sum;
	}

}
