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
			allLines = Files.readAllLines(Paths.get("resources/input04.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Day4A day4A = new Day4A();

		ArrayList<String> testLines = new ArrayList<String>();

		testLines.add("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");
		testLines.add("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19");
		testLines.add("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1");
		testLines.add("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83");
		testLines.add("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36");
		testLines.add("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11");

		int result = day4A.solve(allLines);

		System.out.println("Result:"+result);

	}

}
