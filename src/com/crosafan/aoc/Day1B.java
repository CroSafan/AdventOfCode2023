package com.crosafan.aoc;

import java.util.HashMap;
import java.util.List;

//https://adventofcode.com/2023/day/1
public class Day1B {

	HashMap<Integer, String> wordMap = new HashMap<Integer, String>();

	public Day1B() {
		wordMap.put(1, "one");
		wordMap.put(2, "two");
		wordMap.put(3, "three");
		wordMap.put(4, "four");
		wordMap.put(5, "five");
		wordMap.put(6, "six");
		wordMap.put(7, "seven");
		wordMap.put(8, "eight");
		wordMap.put(9, "nine");
	}

	public int solve(List<String> allLines) {
		int sum = 0;

		for (String line : allLines) {
			String firstDigit = getFirstDigit(line);
			String lastDigit = getLastDigit(line);
			sum += Integer.valueOf(firstDigit + lastDigit);
		}
		return sum;
	}

	private String getFirstDigit(String line) {

		line = firstLetterToDigit(line);

		String[] chars = line.split("");
		for (int i = 0; i < chars.length; i++) {
			if ((chars[i].matches("[0-9]+"))) {
				return chars[i];
			}
		}

		return "";
	}

	private String getLastDigit(String line) {
		line = lastLetterToDigit(line);

		String[] chars = line.split("");

		for (int i = chars.length - 1; i >= 0; i--) {
			if ((chars[i].matches("[0-9]+"))) {
				return chars[i];
			}
		}

		return "";
	}

	private String firstLetterToDigit(String line) {
		int minIndex = -1;
		int minLength = -1;

		for (Integer key : wordMap.keySet()) {
			if (line.indexOf(wordMap.get(key)) != -1) {
				int index = line.indexOf(wordMap.get(key));
				if (index < minIndex || minIndex == -1) {
					minIndex = index;
					minLength = wordMap.get(key).length();
				}

			}
		}
		if (minIndex != -1) {
			String firstNum = line.substring(minIndex, minIndex + minLength);
			line = line.replace(firstNum, getNum(firstNum));

		}
		return line;
	}

	private String lastLetterToDigit(String line) {
		int maxIndex = -1;
		int maxLength = -1;

		for (Integer key : wordMap.keySet()) {
			if (line.indexOf(wordMap.get(key)) != -1) {
				int index = line.indexOf(wordMap.get(key));
				if (index > maxIndex || maxIndex == -1) {
					maxIndex = index;
					maxLength = wordMap.get(key).length();
				}

			}
		}
		if (maxIndex != -1) {
			String lastNum = line.substring(maxIndex, maxIndex + maxLength);
			line = line.replace(lastNum, getNum(lastNum));
		}
		return line;
	}

	private String getNum(String word) {
		for (Integer key : wordMap.keySet()) {
			if (wordMap.get(key).equals(word)) {
				return String.valueOf(key);
			}

		}
		return "";

	}

}
