package com.crosafan.aoc.days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.math3.util.ArithmeticUtils;

import me.tongfei.progressbar.ProgressBar;

public class Day8B {

	public int bruteForceSolve(List<String> allLines) {
		int stepCount = 0;
		int instructionIndex = 0;

		String instructions = allLines.get(0);
		HashMap<String, String[]> map = new HashMap<String, String[]>();

		for (int i = 2; i < allLines.size(); i++) {
			parseLine(map, allLines.get(i));
		}

		List<String> currentLocationsFiltered = map.keySet().stream().filter(n -> n.endsWith("A")).toList();

		ArrayList<String> currentLocations = new ArrayList<String>(currentLocationsFiltered);
		try (ProgressBar pb = new ProgressBar("Following instructions", 0)) { // name, initial max

			while (currentLocations.stream().filter(n -> n.endsWith("Z")).toList().size() != currentLocations.size()) {
				pb.step();
				if (instructionIndex > instructions.length() - 1) {
					instructionIndex = 0;
				}

				for (int i = 0; i < currentLocations.size(); i++) {

					if (instructions.charAt(instructionIndex) == 'R') {
						currentLocations.set(i, map.get(currentLocations.get(i))[1]);
					} else {
						currentLocations.set(i, map.get(currentLocations.get(i))[0]);
					}

				}

				instructionIndex++;
				stepCount++;

			}
		}

		return stepCount;

	}

	public long solve(List<String> allLines) {
		long result = 0;
		int instructionIndex = 0;

		String instructions = allLines.get(0);
		HashMap<String, String[]> map = new HashMap<String, String[]>();

		for (int i = 2; i < allLines.size(); i++) {
			parseLine(map, allLines.get(i));
		}

		ArrayList<String> currentLocations = new ArrayList<String>(
				map.keySet().stream().filter(n -> n.endsWith("A")).toList());
		ArrayList<Integer> steps = new ArrayList<>();
		for (int i = 0; i < currentLocations.size(); i++) {
			steps.add(0);
			instructionIndex = 0;
			while (!currentLocations.get(i).endsWith("Z")) {
				if (instructionIndex > instructions.length() - 1) {
					instructionIndex = 0;
				}

				if (instructions.charAt(instructionIndex) == 'R') {
					currentLocations.set(i, map.get(currentLocations.get(i))[1]);
				} else {
					currentLocations.set(i, map.get(currentLocations.get(i))[0]);
				}
				instructionIndex++;
				steps.set(i, steps.get(i) + 1);
			}

		}

		result = steps.get(0);
		for (int i = 1; i < steps.size(); i++) {
			result = ArithmeticUtils.lcm(result, steps.get(i));

		}

		return result;

	}

	private void parseLine(HashMap<String, String[]> map, String line) {
		map.put(line.split("=")[0].trim(),
				new String[] { line.split("=")[1].trim().replace("(", "").replace(")", "").split(",")[0].trim(),
						line.split("=")[1].trim().replace("(", "").replace(")", "").split(",")[1].trim() });

	}

}
