package com.crosafan.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.crosafan.aoc.days.Day9B;

public class Main {

	public static void main(String[] args) {

		List<String> allLines = null;
		try {
			allLines = Files.readAllLines(Paths.get("resources/input09.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Day9B day9B = new Day9B();

		ArrayList<String> testLines = new ArrayList<String>();
		
		testLines.add("0 3 6 9 12 15");
		testLines.add("1 3 6 10 15 21");
		testLines.add("10 13 16 21 30 45");

		long result = day9B.solve(allLines);

		System.out.println("Result:" + result);

	}

}
