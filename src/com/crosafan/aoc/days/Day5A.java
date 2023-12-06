package com.crosafan.aoc.days;

import java.util.ArrayList;
import java.util.List;

public class Day5A {

	public Long solve(List<String> allLines) {

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
				seeds.add(Long.valueOf(num));
			}

		}

		for (int i = 1; i < allLines.size(); i++) {
			lineToMap(allLines, i, "seed-to-soil map:", inSeedToSoilMap, seedToSoilMap);
			lineToMap(allLines, i, "soil-to-fertilizer map:", inSoilToFertilizerMap, soilToFertilizerMap);
			lineToMap(allLines, i, "fertilizer-to-water map:", inFertilizerToWaterMap, fertilizerToWaterMap);
			lineToMap(allLines, i, "water-to-light map:", inWaterToLightMap, waterToLightMap);
			lineToMap(allLines, i, "light-to-temperature map:", inLightToTemperature, lightToTemperatureMap);
			lineToMap(allLines, i, "temperature-to-humidity map:", longemperatureToHumidity, temperatureToHumidityMap);
			lineToMap(allLines, i, "humidity-to-location map:", inHumidityToLocation, humidityToLocationMap);
		}

//		System.out.println("Starting mappings");
//		ArrayList<ArrayList<Long>> mappings1 = mapToMappings(seedToSoilMap);
//		System.out.println("Starting mappings2");
//
//		ArrayList<ArrayList<Long>> mappings2 = mapToMappings(soilToFertilizerMap);
//		System.out.println("Starting mappings3");
//
//		ArrayList<ArrayList<Long>> mappings3 = mapToMappings(fertilizerToWaterMap);
//		System.out.println("Starting mappings4");
//
//		ArrayList<ArrayList<Long>> mappings4 = mapToMappings(waterToLightMap);
//		System.out.println("Starting mappings5");
//
//		ArrayList<ArrayList<Long>> mappings5 = mapToMappings(lightToTemperatureMap);
//		System.out.println("Starting mappings6");
//
//		ArrayList<ArrayList<Long>> mappings6 = mapToMappings(temperatureToHumidityMap);
//		System.out.println("Starting mappings7");
//
//		ArrayList<ArrayList<Long>> mappings7 = mapToMappings(humidityToLocationMap);
//		System.out.println("Starting mappings");

		System.out.println("Ended mappings");
		ArrayList<Long> locations = new ArrayList<Long>();

		for (Long seed : seeds) {

			long map1 = findKeyInMap(seed, seedToSoilMap);
			long map2 = findKeyInMap(map1, soilToFertilizerMap);

			long map3 = findKeyInMap(map2, fertilizerToWaterMap);

			long map4 = findKeyInMap(map3, waterToLightMap);

			long map5 = findKeyInMap(map4, lightToTemperatureMap);

			long map6 = findKeyInMap(map5, temperatureToHumidityMap);

			long map7 = findKeyInMap(map6, humidityToLocationMap);

			locations.add(map7);
			System.out.println("Finished seed " + map7 + " out of:" + seeds.size());
		}
//		for (long i = 0; i < mappings1.length; i++) {
//			System.out.prlongln(mappings1[i][0] + ":" + mappings1[i][1]);
//
//		}

		locations.sort(null);

		return locations.get(0);
	}

	public long findKeyInMap(long key, ArrayList<ArrayList<Long>> map) {
		long result = 0;

		// map.get(i).get(0) // soil start
		// map.get(i).get(1) // seed start
		// map.get(i).get(2) -- step

		for (int i = 0; i < map.size(); i++) {
			long startRange = map.get(i).get(1);

			long endRange = map.get(i).get(1) + map.get(i).get(2);

			long mapping = map.get(i).get(0);
			if (key >= startRange && key <= endRange) {

				for (long x = startRange; x < endRange; x++) {
					if (key == x) {
						result = mapping;
					}
					mapping++;
				}
			}

		}
		if (result == 0) {
			result = key;
		}

		return result;

	}

	private ArrayList<ArrayList<Long>> mapToMappings(ArrayList<ArrayList<Long>> seedToSoilMap) {

		ArrayList<ArrayList<Long>> array = new ArrayList<ArrayList<Long>>();

		for (ArrayList<Long> row : seedToSoilMap) {
			long destinationRangeStart = row.get(0); // soil start
			long sourceRangeStart = row.get(1);// seed start
			long rangeLength = row.get(2);// steos
			while (rangeLength > 0) {
				ArrayList<Long> pair = new ArrayList<Long>();
				pair.add(sourceRangeStart);
				pair.add(destinationRangeStart);
				array.add(pair);
				rangeLength--;
				sourceRangeStart++;
				destinationRangeStart++;
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
