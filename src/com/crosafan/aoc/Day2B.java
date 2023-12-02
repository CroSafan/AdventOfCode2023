package com.crosafan.aoc;

import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Day2B {

	public int solve(List<String> inputLines) {
		// testLines.add("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
		int sum = 0;
		for (String line : inputLines) {
			int gameId = Integer.parseInt(line.split(":")[0].split(" ")[1]);
			String cubes = line.split(":")[1].trim();
			String[] cubeSubsets = cubes.split(";");
			boolean isPossible = true;
			int maxRedCount = 0, maxGreenCount = 0, maxBlueCount = 0;

			for (String subset : cubeSubsets) {
				int redCount = 0, greenCount = 0, blueCount = 0;

				String[] grab = subset.split(",");
				for (String cube : grab) {
					int count = Integer.parseInt(cube.trim().split(" ")[0]);
					String color = cube.trim().split(" ")[1];
					if (color.equals("red")) {
						redCount = count;
					} else if (color.equals("green")) {
						greenCount = count;
					} else if (color.equals("blue")) {
						blueCount = count;

					}
				}

				if (redCount > maxRedCount)
					maxRedCount = redCount;
				if (greenCount > maxGreenCount)
					maxGreenCount = greenCount;
				if (blueCount > maxBlueCount)
					maxBlueCount = blueCount;

			}

			int power = maxRedCount * maxGreenCount * maxBlueCount;
			sum += power;

		}

		return sum;
	}

}
