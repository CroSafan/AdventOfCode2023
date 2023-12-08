package com.crosafan.aoc.days;

import java.util.ArrayList;
import java.util.List;

import com.crosafan.aoc.AOCHelper;

public class Day6A {

	public int solve(List<String> allLines) {
		int result = 1;
		ArrayList<Integer> times = new ArrayList<Integer>();
		ArrayList<Integer> distances = new ArrayList<Integer>();
		ArrayList<Integer> allWays = new ArrayList<Integer>();
		for (String time : allLines.get(0).split(":")[1].replace("  ", " ").split(" ")) {
			if (AOCHelper.isNumber(time)) {
				times.add(Integer.parseInt(time));
			}
		}
		for (String distance : allLines.get(1).split(":")[1].replace("  ", " ").split(" ")) {
			if (AOCHelper.isNumber(distance)) {
				distances.add(Integer.parseInt(distance));
			}
		}

		for (int i = 0; i < times.size(); i++) {

			int timePressed = 0;
			int numberOfWaysToBeat = 0;
			for (int j = 0; j < times.get(i); j++) {

				int distanceTraveled = (times.get(i) - timePressed) * timePressed;
				if (distanceTraveled > distances.get(i)) {
					numberOfWaysToBeat++;

				}

				timePressed++;

			}
			allWays.add(numberOfWaysToBeat);

		}

		for (Integer num : allWays) {
			result = result * num;
		}

		return result;
	}

}
