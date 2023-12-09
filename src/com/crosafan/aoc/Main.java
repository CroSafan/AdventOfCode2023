package com.crosafan.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.crosafan.aoc.days.Day8B;

public class Main {

	public static void main(String[] args) {

		List<String> allLines = null;
		try {
			allLines = Files.readAllLines(Paths.get("resources/input08.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Day8B day8B = new Day8B();

		ArrayList<String> testLines = new ArrayList<String>();

		testLines.add("LR");
		testLines.add("");
		testLines.add("11A = (11B, XXX)");
		testLines.add("11B = (XXX, 11Z)");
		testLines.add("11Z = (11B, XXX)");
		testLines.add("22A = (22B, XXX)");
		testLines.add("22B = (22C, 22C)");
		testLines.add("22C = (22Z, 22Z)");
		testLines.add("22Z = (22B, 22B)");
		testLines.add("XXX = (XXX, XXX)");
		
		long result = day8B.solve(allLines);

		System.out.println("Result:" + result);

	}

}
