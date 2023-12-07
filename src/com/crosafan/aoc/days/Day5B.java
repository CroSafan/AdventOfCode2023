package com.crosafan.aoc.days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.tongfei.progressbar.ProgressBar;

public class Day5B {

	public Long solve(List<String> allLines) {
		ArrayList<Long> nums = new ArrayList<Long>();
		ArrayList<Long> seeds = new ArrayList<Long>();
		ArrayList<ArrayList<Long>> seedToSoilMap = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> soilToFertilizerMap = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> fertilizerToWaterMap = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> waterToLightMap = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> lightToTemperatureMap = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> temperatureToHumidityMap = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> humidityToLocationMap = new ArrayList<ArrayList<Long>>();
		Flag inSeedToSoilMap = new Flag();
		Flag inSoilToFertilizerMap = new Flag();
		Flag inFertilizerToWaterMap = new Flag();
		Flag inWaterToLightMap = new Flag();
		Flag inLightToTemperature = new Flag();
		Flag longemperatureToHumidity = new Flag();
		Flag inHumidityToLocation = new Flag();

		for (String num : allLines.get(0).split(": ")[1].split(" ")) {
			if (isNumber(num)) {
				nums.add(Long.valueOf(num));
			}

		}

		for (int i = 0; i < nums.size(); i = i + 2) {
			long start = nums.get(i);
			long range = nums.get(i + 1);
//			long step= range/3;
			for (long j = 0; j <= range; j++) {
				seeds.add(start + j);
			}
		}

//		for(int i = 0;i<nums.size();i++) {
//			seeds.add(nums.get(i));
//		}

		for (int i = 1; i < allLines.size(); i++) {
			lineToMap(allLines, i, "seed-to-soil map:", inSeedToSoilMap, seedToSoilMap);
			lineToMap(allLines, i, "soil-to-fertilizer map:", inSoilToFertilizerMap, soilToFertilizerMap);
			lineToMap(allLines, i, "fertilizer-to-water map:", inFertilizerToWaterMap, fertilizerToWaterMap);
			lineToMap(allLines, i, "water-to-light map:", inWaterToLightMap, waterToLightMap);
			lineToMap(allLines, i, "light-to-temperature map:", inLightToTemperature, lightToTemperatureMap);
			lineToMap(allLines, i, "temperature-to-humidity map:", longemperatureToHumidity, temperatureToHumidityMap);
			lineToMap(allLines, i, "humidity-to-location map:", inHumidityToLocation, humidityToLocationMap);
		}
		ArrayList<Long> temp = new ArrayList<Long>();
		ArrayList<Long> locations = new ArrayList<Long>();

		long[][] array = convertTo2DArray(seedToSoilMap);
		seedToSoilMap = null;
		long[][] array1 = convertTo2DArray(soilToFertilizerMap);
		soilToFertilizerMap = null;
		long[][] array2 = convertTo2DArray(fertilizerToWaterMap);
		fertilizerToWaterMap = null;
		long[][] array3 = convertTo2DArray(waterToLightMap);
		waterToLightMap = null;
		long[][] array4 = convertTo2DArray(lightToTemperatureMap);
		lightToTemperatureMap = null;
		long[][] array5 = convertTo2DArray(temperatureToHumidityMap);
		temperatureToHumidityMap = null;
		long[][] array6 = convertTo2DArray(humidityToLocationMap);
		humidityToLocationMap = null;

		try (ProgressBar pb = new ProgressBar("Seeds processed", seeds.size())) { // name, initial max

			for (Long seed : seeds) {
				pb.step();
				long map1 = findKeyInMap(seed, array);
				long map2 = findKeyInMap(map1, array1);

				long map3 = findKeyInMap(map2, array2);

				long map4 = findKeyInMap(map3, array3);

				long map5 = findKeyInMap(map4, array4);

				long map6 = findKeyInMap(map5, array5);

				long map7 = findKeyInMap(map6, array6);

				temp.add(map7);

				if (temp.size() > 10000000) {

					locations.add(Collections.min(temp));

					temp.clear();
				}

			}

		} //

		return Collections.min(locations);
	}

	public long findKeyInMap(long key, long[][] array) {
		long result = 0;

		// map.get(i).get(0) // soil start
		// map.get(i).get(1) // seed start
		// map.get(i).get(2) -- step

		for (int i = 0; i < array.length; i++) {
			long startRange = array[i][1];

			long endRange = startRange + array[i][2];

			long mapping = array[i][0];
			if (key >= startRange && key <= endRange) {

				result = key - startRange + mapping;
				return result;
			}

		}
		if (result == 0) {
			result = key;
		}

		return result;

	}

	public static long[][] convertTo2DArray(ArrayList<ArrayList<Long>> list) {
		int rows = list.size();
		int cols = 0;

		// Find the maximum length of inner ArrayLists
		for (ArrayList<Long> innerList : list) {
			cols = Math.max(cols, innerList.size());
		}

		long[][] array = new long[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				array[i][j] = list.get(i).get(j);
			}
		}

		return array;
	}

	public boolean isNumber(String input) {
		return input.matches("[0-9]+");
	}

	public void lineToMap(List<String> allLines, int i, String matchWord, Flag flag,
			ArrayList<ArrayList<Long>> humidityToLocationMap) {
		if (allLines.get(i).startsWith(matchWord)) {
			flag.setInMap(true);
			;
		}

		if (!allLines.get(i).isEmpty() && flag.isInMap()) {
			ArrayList<Long> row = new ArrayList<Long>();

			for (String num : allLines.get(i).split(" ")) {
				if (isNumber(num)) {
					row.add(Long.parseLong(num));
				}

			}
			if (row.size() > 0) {
				humidityToLocationMap.add(row);
			}

		}
		if (allLines.get(i).isEmpty() && flag.isInMap()) {
			flag.setInMap(false);
		}
	}

	class Flag {

		public Flag() {
			this.inMap = false;
		}

		private boolean inMap;

		public boolean isInMap() {
			return inMap;
		}

		public void setInMap(boolean inMap) {
			this.inMap = inMap;
		}

	}

}
