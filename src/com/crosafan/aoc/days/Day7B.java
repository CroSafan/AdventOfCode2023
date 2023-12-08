package com.crosafan.aoc.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day7B {

	public int solve(List<String> allLines) {
		int result = 0;
		ArrayList<Hand> hands = new ArrayList<Day7B.Hand>();

		for (String line : allLines) {
			Hand hand = new Hand(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
			hands.add(hand);
		}

		Comparator<Hand> handScoreComparator = new Comparator<Hand>() {

			@Override
			public int compare(Hand h1, Hand h2) {
				return Integer.compare(h1.getScore(), h2.getScore());
			}
		};

		Comparator<Hand> weightComparator = new Comparator<Hand>() {

			@Override
			public int compare(Hand h1, Hand h2) {

				for (int j = 0; j < 5; j++) {

					if (h1.getCards().charAt(j) != h2.getCards().charAt(j)) {
						return Integer.compare(Hand.scoreCard(h1.getCards().charAt(j)),
								Hand.scoreCard(h2.getCards().charAt(j)));
					}

				}

				return 0;
			}
		};
		HashMap<Integer, ArrayList<Hand>> handMap = new HashMap<Integer, ArrayList<Hand>>();
		Collections.sort(hands, handScoreComparator);
		// grouping scores
		for (Hand hand : hands) {

			if (handMap.containsKey(hand.getScore())) {
				handMap.get(hand.getScore()).add(hand);
			} else {
				ArrayList<Day7B.Hand> subHands = new ArrayList<Day7B.Hand>();
				subHands.add(hand);
				handMap.put(hand.getScore(), subHands);
			}

		}

		hands.clear();
		for (int key : handMap.keySet()) {
			Collections.sort(handMap.get(key), weightComparator);
			hands.addAll(handMap.get(key));
		}

		for (int i = 0; i < hands.size(); i++) {
			result += (i + 1) * hands.get(i).getBid();
		}

		return result;

	}

	public class Hand {
		private String cards;
		private int bid;
		private int score;

		public Hand(String cards, int bid) {
			this.cards = cards;
			this.bid = bid;
			this.score = maxScoreHand(cards);
		}

		private int maxScoreHand(String hand) {
			int maxScore = 0;

			if (hand.contains("J")) {
				String handCopy = hand;
				String[] possibilities = new String[] { "A", "K", "Q", "T", "9", "8", "7", "6", "5", "4", "3", "2" };
				for (String possibility : possibilities) {
					if (scoreHand(handCopy.replace("J", possibility)) > maxScore) {
						maxScore = scoreHand(handCopy.replace("J", possibility));
					}

				}

			} else {
				return scoreHand(hand);
			}

			return maxScore;

		}

		private int scoreHand(String hand) {
			int score = 0;

			if (isFiveOfKind(hand)) {
				score = 7;
			} else if (isFourOfKind(hand)) {
				score = 6;
			} else if (isFullHouse(hand)) {
				score = 5;
			} else if (isThreeOfKind(hand)) {
				score = 4;
			} else if (isTwoPair(hand)) {
				score = 3;
			} else if (isOnePair(hand)) {
				score = 2;
			} else if (isHighCard(hand)) {
				score = 1;
			}

			return score;
		}

		private boolean isHighCard(String hand) {
			return hand.chars().mapToObj(e -> Character.toString((char) e)).distinct().toList().size() == 5;
		}

		private boolean isOnePair(String hand) {
			Map<String, Long> output = Arrays.stream(hand.split(""))
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			int pairCount = 0;
			for (String key : output.keySet()) {
				if (output.get(key) == 2L) {
					pairCount++;
				}
			}
			if (pairCount == 1) {
				return true;
			}

			return false;
		}

		private boolean isTwoPair(String hand) {
			Map<String, Long> output = Arrays.stream(hand.split(""))
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			int pairCount = 0;
			for (String key : output.keySet()) {
				if (output.get(key) == 2L) {
					pairCount++;
				}
			}
			if (pairCount == 2) {
				return true;
			}

			return false;
		}

		public boolean isThreeOfKind(String hand) {
			Map<String, Long> output = Arrays.stream(hand.split(""))
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			if (output.keySet().size() == 3) {
				boolean threeDisinct = false;
				boolean twoDistinct = false;
				for (String key : output.keySet()) {
					if (output.get(key) == 2L) {
						twoDistinct = true;
					}
					if (output.get(key) == 3L) {
						threeDisinct = true;
					}
					if (threeDisinct && !twoDistinct) {
						return true;
					}

				}
			}

			return false;
		}

		// Full house, where three cards have the same label, and the remaining two
		// cards share a different label: 23332
		public boolean isFullHouse(String hand) {
			Map<String, Long> output = Arrays.stream(hand.split(""))
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			if (output.keySet().size() == 2) {
				boolean threeDisinct = false;
				boolean twoDistinct = false;
				for (String key : output.keySet()) {
					if (output.get(key) == 2L) {
						twoDistinct = true;
					}
					if (output.get(key) == 3L) {
						threeDisinct = true;
					}
					if (threeDisinct && twoDistinct) {
						return true;
					}

				}
			}

			return false;
		}

		public boolean isFourOfKind(String hand) {

			Map<String, Long> output = Arrays.stream(hand.split(""))
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			for (String key : output.keySet()) {
				if (output.get(key) == 4L) {
					return true;
				}
			}

			return false;
		}

		public boolean isFiveOfKind(String hand) {
			if (hand.chars().filter(ch -> ch == hand.charAt(0)).count() == 5) {
				return true;
			}

			return false;
		}

		public String getCards() {
			return cards;
		}

		public void setCards(String cards) {
			this.cards = cards;
		}

		public int getBid() {
			return bid;
		}

		public void setBid(int bid) {
			this.bid = bid;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public static int scoreCard(char card) {
			int score = 0;
			switch (card) {
			case 'A': {
				return 13;
			}
			case 'K': {
				return 12;
			}
			case 'Q': {
				return 11;
			}
			case 'T': {
				return 10;
			}
			case '9': {
				return 9;
			}
			case '8': {
				return 8;
			}
			case '7': {
				return 7;
			}
			case '6': {
				return 6;
			}
			case '5': {
				return 5;
			}
			case '4': {
				return 4;
			}
			case '3': {
				return 3;
			}
			case '2': {
				return 2;
			}
			case 'J': {
				return 1;
			}
			default:
				break;
			}

			return score;

		}

	}

	public void test() {
		Hand testHand = new Hand("AAAAA", 0);

		if (testHand.isFiveOfKind("AAAAA")) {
			System.out.println("It is five kind");
		}

		if (testHand.isFourOfKind("A3AAA")) {
			System.out.println("It is four kind");
		}
		if (testHand.isFullHouse("23332")) {
			System.out.println("Full house");
		}
		if (testHand.isThreeOfKind("TTT98")) {
			System.out.println("Three of a kind");
		}
		if (testHand.isTwoPair("23432")) {
			System.out.println("Two pair");
		}

		if (testHand.isOnePair("A23A4")) {
			System.out.println("One pair");
		}
		if (testHand.isHighCard("23456")) {
			System.out.println("High card");
		}

	}
}
