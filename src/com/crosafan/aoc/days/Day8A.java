package com.crosafan.aoc.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day8A {

	public int solve(List<String> allLines) {
		int stepCount = 0;
		String currentLocation = "AAA";

		String instuctions = allLines.get(0);
		int instuctionIndex = 0;
		// testLines.add("AAA = (BBB, CCC)");

		int lineIndex = 2;

		while (!currentLocation.equals("ZZZ")) {
			if (lineIndex == allLines.size()) {
				lineIndex = 2;
			}
			if (instuctionIndex == instuctions.length()) {
				instuctionIndex = 0;
			}

			String[] result = parseLine(allLines.get(lineIndex));
			if (currentLocation.equals(result[0])) {
				if (instuctions.charAt(instuctionIndex) == 'L') {
					currentLocation = result[1];
				} else {
					currentLocation = result[2];
				}
				stepCount++;
				instuctionIndex++;
			}

			lineIndex++;

		}

		return stepCount;

	}

	private String[] parseLine(String line) {
		String[] values = new String[3];

		values[0] = line.split("=")[0].trim();

		values[1] = line.split("=")[1].trim().replace("(", "").replace(")", "").split(",")[0].trim();
		values[2] = line.split("=")[1].trim().replace("(", "").replace(")", "").split(",")[1].trim();

		return values;
	}

}
