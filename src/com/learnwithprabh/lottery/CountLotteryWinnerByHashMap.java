package com.learnwithprabh.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountLotteryWinnerByHashMap {

	public static void main(String[] args) {
		int i = findWinner(21);
		//System.out.println(i);
	}

	static int findWinner(int number) {
		Map<Integer, Integer> digitSumMap = new HashMap<>();

		for (int i = 1; i <= number; i++) {
			int sum = addDigit(i);
			if (digitSumMap.containsKey(sum)) {
				digitSumMap.put(sum, digitSumMap.get(sum) + 1);
			} else {
				digitSumMap.put(sum, 1);
			}
		}

		List<Integer> noOfWinnerList = new ArrayList<>(digitSumMap.values());
		Collections.sort(noOfWinnerList);
		Integer maxOccurance = noOfWinnerList.get(noOfWinnerList.size() - 1);
		int noOfWinner = 0;

		for (Integer key : digitSumMap.keySet()) {
			if (digitSumMap.get(key) == maxOccurance) {
				noOfWinner++;
			}
		}

		return noOfWinner;
	}

	static int addDigit(int number) {
		int sum = 0;
		while (number != 0) {
			int reminder = number % 10;
			sum = sum + reminder;
			number = number / 10;
		}
		return sum;
	}

}
