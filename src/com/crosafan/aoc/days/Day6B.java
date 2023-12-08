package com.crosafan.aoc.days;

import java.util.ArrayList;
import java.util.List;

import com.crosafan.aoc.AOCHelper;

public class Day6B {

	public int solve(List<String> allLines) {
		int numberOfWaysToBeat = 0;

		Long raceTime = 0L;
		Long raceDistance = 0L;

		String timeString = "";
		String distanceString = "";
		for (String time : allLines.get(0).split(":")[1].replace("  ", " ").split(" ")) {
			if (AOCHelper.isNumber(time)) {
				timeString += time;
			}
		}
		for (String distance : allLines.get(1).split(":")[1].replace("  ", " ").split(" ")) {
			if (AOCHelper.isNumber(distance)) {
				distanceString += distance;
			}
		}

		raceTime = Long.parseLong(timeString);
		raceDistance = Long.parseLong(distanceString);

		int timePressed = 0;
		for (int j = 0; j < raceTime; j++) {

			Long distanceTraveled = (raceTime - timePressed) * timePressed;
			if (distanceTraveled > raceDistance) {
				numberOfWaysToBeat++;

			}

			timePressed++;

		}

		return numberOfWaysToBeat;
	}

}
