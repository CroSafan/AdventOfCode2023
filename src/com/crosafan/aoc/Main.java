package com.crosafan.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.crosafan.aoc.days.Day4B;
import com.crosafan.aoc.days.Day5A;
import com.crosafan.aoc.days.Day5B;
import com.crosafan.aoc.days.Day6A;
import com.crosafan.aoc.days.Day6B;

public class Main {

	public static void main(String[] args) {

		List<String> allLines = null;
		try {
			allLines = Files.readAllLines(Paths.get("resources/input06.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Day6B day6B = new Day6B();

		ArrayList<String> testLines = new ArrayList<String>();

		testLines.add("Time:      7  15   30");
		testLines.add("Distance:  9  40  200");
		int result = day6B.solve(allLines);

		System.out.println("Result:" + result);

	}

}
