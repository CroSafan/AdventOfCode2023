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
			allLines = Files.readAllLines(Paths.get("resources/input01A.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Day1A day1A = new Day1A();
		
		ArrayList<String> testLines=new ArrayList<String>();
		
		testLines.add("1abc2");
		testLines.add("pqr3stu8vwx");
		testLines.add("a1b2c3d4e5f");
		testLines.add("treb7uchet");
		
		

		int result = day1A.solve(allLines);

		System.out.println(result);

	}

}
