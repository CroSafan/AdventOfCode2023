package com.crosafan.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<String> allLines = null;
		try {
			allLines = Files.readAllLines(Paths.get("resources/input01.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Day1B day1B = new Day1B();

		ArrayList<String> testLines = new ArrayList<String>();

		testLines.add("two1nine");
		testLines.add("eightwothree");
		testLines.add("abcone2threexyz");
		testLines.add("xtwone3four");
		testLines.add("4nineeightseven2");
		testLines.add("zoneight234");
		testLines.add("7pqrstsixteen");

		int result = day1B.solve(allLines);

		System.out.println(result);

	}

}
