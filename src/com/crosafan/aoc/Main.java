package com.crosafan.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.crosafan.aoc.days.Day8A;

public class Main {

	public static void main(String[] args) {

		List<String> allLines = null;
		try {
			allLines = Files.readAllLines(Paths.get("resources/input08.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Day8A day8A = new Day8A();

		ArrayList<String> testLines = new ArrayList<String>();

		testLines.add("RL");
		testLines.add("");
		testLines.add("AAA = (BBB, CCC)");
		testLines.add("BBB = (DDD, EEE)");
		testLines.add("CCC = (ZZZ, GGG)");
		testLines.add("DDD = (DDD, DDD)");
		testLines.add("EEE = (EEE, EEE)");
		testLines.add("GGG = (GGG, GGG)");
		testLines.add("ZZZ = (ZZZ, ZZZ)");
		int result = day8A.solve(allLines);

		System.out.println("Result:" + result);

	}

}
