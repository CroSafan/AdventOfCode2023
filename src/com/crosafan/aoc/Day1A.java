package com.crosafan.aoc;

import java.util.List;

//https://adventofcode.com/2023/day/1
public class Day1A {

	public int solve(List<String> allLines) {
		int sum = 0;

		for (String line : allLines) {
			String firstDigit = getFirstDigit(line);
			String lastDigit = getLastDigit(line);
			sum += Integer.valueOf(firstDigit + lastDigit);
		}
		return sum;
	}

	private String getLastDigit(String line) {

		String[] chars = line.split("");

		for (int i = chars.length - 1; i >= 0; i--) {
			if ((chars[i].matches("[0-9]+"))) {
				return chars[i];
			}
		}

		return "";
	}

	private String getFirstDigit(String line) {
		String[] chars = line.split("");
		for (int i = 0; i < chars.length; i++) {
			if ((chars[i].matches("[0-9]+"))) {
				return chars[i];
			}
		}

		return "";
	}

}
