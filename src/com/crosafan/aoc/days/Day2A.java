package com.crosafan.aoc.days;

import java.util.List;

public class Day2A {

	public int solve(List<String> inputLines, int redCountInput, int greenCountInput, int blueCountInput) {
		// testLines.add("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
		int sum = 0;
		for (String line : inputLines) {
			int gameId = Integer.parseInt(line.split(":")[0].split(" ")[1]);
			String cubes = line.split(":")[1].trim();
			String[] cubeSubsets = cubes.split(";");
			boolean isPossible = true;
			for (String subset : cubeSubsets) {
				int redCount = 0, greenCount = 0, blueCount = 0;

				String[] grab = subset.split(",");
				for (String cube : grab) {
					int count = Integer.parseInt(cube.trim().split(" ")[0]);
					String color = cube.trim().split(" ")[1];
					if (color.equals("red")) {
						redCount += count;
					} else if (color.equals("green")) {
						greenCount += count;
					} else if (color.equals("blue")) {
						blueCount += count;

					}
				}

				if (redCount > redCountInput || greenCount > greenCountInput || blueCount > blueCountInput) {
					isPossible = false;
				}

			}

			if (isPossible) {
				sum += gameId;
			}

		}

		return sum;
	}

}
