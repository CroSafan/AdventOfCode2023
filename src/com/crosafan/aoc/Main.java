package com.crosafan.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.crosafan.aoc.days.Day4B;
import com.crosafan.aoc.days.Day5A;

public class Main {

	public static void main(String[] args) {

		List<String> allLines = null;
		try {
			allLines = Files.readAllLines(Paths.get("resources/input05.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Day5A day5A = new Day5A();

		ArrayList<String> testLines = new ArrayList<String>();

		testLines.add("seeds: 79 14 55 13");
		testLines.add("");
		testLines.add("seed-to-soil map:");
		testLines.add("50 98 2");
		testLines.add("52 50 48");
		testLines.add("");
		testLines.add("soil-to-fertilizer map:");
		testLines.add("0 15 37");
		testLines.add("37 52 2");
		testLines.add("39 0 15");
		testLines.add("");
		testLines.add("fertilizer-to-water map:");
		testLines.add("49 53 8");
		testLines.add("0 11 42");
		testLines.add("42 0 7");
		testLines.add("57 7 4");
		testLines.add("");
		testLines.add("water-to-light map:");
		testLines.add("88 18 7");
		testLines.add("18 25 70");
		testLines.add("");
		testLines.add("light-to-temperature map:");
		testLines.add("45 77 23");
		testLines.add("81 45 19");
		testLines.add("68 64 13");
		testLines.add("");
		testLines.add("temperature-to-humidity map:");
		testLines.add("0 69 1");
		testLines.add("1 0 69");
		testLines.add("");
		testLines.add("humidity-to-location map:");
		testLines.add("60 56 37");
		testLines.add("56 93 4");

		long result = day5A.solve(allLines);

		System.out.println("Result:"+result);

	}

}
