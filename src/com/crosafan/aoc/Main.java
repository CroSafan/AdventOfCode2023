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
			allLines = Files.readAllLines(Paths.get("resources/input03.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Day3A day3A = new Day3A();

		ArrayList<String> testLines = new ArrayList<String>();

		testLines.add("467..114..");
		testLines.add("...*......");
		testLines.add("..35..633.");
		testLines.add("......#...");
		testLines.add("617*......");
		testLines.add(".....+.58.");
		testLines.add("..592.....");
		testLines.add("......755.");
		testLines.add("...$.*....");
		testLines.add(".664.598..");

		int result = day3A.solve(allLines);

		System.out.println("Result:"+result);

	}

}
