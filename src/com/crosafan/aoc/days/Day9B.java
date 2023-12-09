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

public class Day9B {

	public int solve(List<String> allLines) {
		int result = 0;

		for (String line : allLines) {
			result += predictValue(line);
		}
		return result;

	}

	private int predictValue(String line) {
		ArrayList<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();

		String[] values = line.split(" ");

		rows.add(new ArrayList<Integer>());

		for (String value : values) {
			rows.get(0).add(Integer.valueOf(value));
		}

		for (int i = 0; i < rows.size(); i++) {
			rows.add(new ArrayList<Integer>());
			for (int j = 0; j < rows.get(i).size() - 1; j++) {
				int diff = rows.get(i).get(j + 1) - rows.get(i).get(j);
				rows.get(i + 1).add(diff);
			}
			if (rows.get(i + 1).stream().distinct().toList().get(0) == 0 && rows.get(i + 1).isEmpty()
					|| rows.get(i + 1).stream().allMatch(rows.get(i + 1).get(0)::equals)) {
				break;
			}
		}

		int result = 0;
		for (int i = rows.size() - 1; i >= 0; i--) {
			int firstNum = rows.get(i).get(0);

			result = firstNum - result;

		}

		return result;
	}

}
