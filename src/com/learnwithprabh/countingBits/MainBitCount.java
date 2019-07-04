package com.learnwithprabh.countingBits;

import java.util.Arrays;

public class MainBitCount {
	// ned to count the index of 1 in bit stream of input.
	public static void main(String[] args) {
		int input = 8;
		int bitarray[] = convertIntBit(input);
		printIntSolution(bitarray);
	}

	public static int[] convertIntBit(int num) {
		int bitInput[] = new int[100000];
		int i = 0;
		while (num!= 0) {
			num = num/2;
			bitInput[i] = num%2;
			//System.out.println(bitInput[i]);
			i++;
		}
		return Arrays.copyOfRange(bitInput,0,i);
	}

	public static void printIntSolution(int input[]) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
		}
		System.out.println();
	}

}
