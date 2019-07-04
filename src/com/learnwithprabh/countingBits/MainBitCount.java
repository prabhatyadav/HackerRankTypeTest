package com.learnwithprabh.countingBits;

import java.util.Arrays;
import java.util.Scanner;

public class MainBitCount {
	// ned to count the index of 1 in bit stream of input.
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int no = scn.nextInt();
		char[] toBin = Integer.toBinaryString(no).toCharArray();
		int[] position = new int[toBin.length];
		System.out.println(toBin);
		int j = 0;
		int length = 0;
		for (int i = 0; i < toBin.length; i++) {
			int pos = i;
			if (toBin[i] == '1') {
				position[length] = pos + 1;
				length++;
			}
		}
		position = Arrays.copyOf(position, length);
		for (int i : position) {
			System.out.println(i);
		}
	}

}
