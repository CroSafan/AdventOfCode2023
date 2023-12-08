package com.crosafan.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.crosafan.aoc.days.Day7B;

public class Main {

	public static void main(String[] args) {

		List<String> allLines = null;
		try {
			allLines = Files.readAllLines(Paths.get("resources/input07.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Day7B day7B = new Day7B();

		ArrayList<String> testLines = new ArrayList<String>();

		testLines.add("32T3K 765");
		testLines.add("T55J5 684");
		testLines.add("KK677 28");
		testLines.add("KTJJT 220");
		testLines.add("QQQJA 483");
		int result = day7B.solve(allLines);

		System.out.println("Result:" + result);

	}

}
