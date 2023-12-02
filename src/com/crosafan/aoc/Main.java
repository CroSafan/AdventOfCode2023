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
			allLines = Files.readAllLines(Paths.get("resources/input02.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Day2A day2A = new Day2A();

		ArrayList<String> testLines = new ArrayList<String>();

		testLines.add("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
		testLines.add("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue");
		testLines.add("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red");
		testLines.add("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red");
		testLines.add("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green");

		int redCount = 12, greenCount = 13, blueCount = 14;
		
		int result = day2A.solve(allLines,redCount,greenCount,blueCount);

		System.out.println(result);

	}

}
