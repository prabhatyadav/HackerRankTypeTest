package com.learnwithprabh.lottery;

public class CountLotteryWinner {

	public static void main(String[] args) {
		int couponCount = 3; // inert the count of lottery here
		int lotteryWinnerCountArray[] = new int[36];
		for (int i = 0; i <= couponCount; i++) {
			int digitSum = sumOfTheDigit(i);
			lotteryWinnerCountArray[digitSum] = lotteryWinnerCountArray[digitSum] + 1;
		}
		// printArray(lotteryWinnerCountArray);
		System.out.println(gethigestSum(lotteryWinnerCountArray));
	}

	public static int sumOfTheDigit(int digit) {
		int sum = 0;
		while (digit != 0) {
			digit = digit % 10;
			sum = sum + digit;
			digit = digit / 10;
		}
		return sum;
	}

	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int gethigestSum(int arr[]) {
		int highest = 0;
		int highestCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (highest < arr[i]) {
				highest = arr[i];
				highestCount = 1;
			} else if (highest == arr[i]) {
				highestCount++;
			}
		}
		return highestCount;
	}

}
