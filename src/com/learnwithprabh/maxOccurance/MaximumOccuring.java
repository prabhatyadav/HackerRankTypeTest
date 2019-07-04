package com.learnwithprabh.maxOccurance;

public class MaximumOccuring {
	static String input = "aabbaabbbcc";

	public static void main(String args[]) {
		int maxOccuringCount = 0;
		char maxOccuringChar = '$';
		int value = 0;

		char charArray[] = input.toCharArray();
		int inputCount = charArray.length;
		char tempChar = '0';
		for (int j = 0; j < inputCount; j++) {
			if (charArray[j] != '0') {
				tempChar = charArray[j];
				value = 0;
			}
			for (int i = 0; i < inputCount; i++) {
				if (tempChar == charArray[i]) {
					value++;
					charArray[i] = '0';
				}
			}
			if (maxOccuringCount < value) {
				maxOccuringCount = value;
				maxOccuringChar = tempChar;
			}
		}
		System.out.println("maxOccureCount:" + maxOccuringCount);
		System.out.println("maxOccureChar:" + maxOccuringChar);
	}

}
