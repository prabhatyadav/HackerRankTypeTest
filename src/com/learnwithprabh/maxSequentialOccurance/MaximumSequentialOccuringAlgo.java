package com.learnwithprabh.maxSequentialOccurance;

public class MaximumSequentialOccuringAlgo {
	//static String input = "aabbbbbcccc";
	static String input = "aaeeeeaabbbb";

	public static void main(String args[]) {
		char charArray[] = input.toCharArray();
		char temp = '@';
		int value = 0;
		char maxOccureChar='$';
		int maxOccureCount=0;
		for (int i = 0; i < charArray.length; i++) {
			if (temp == charArray[i]) {
				value++;
				if(maxOccureCount < value) {
					maxOccureCount=value;
					maxOccureChar=temp;
				}
			} else {
				
				if(maxOccureCount < value) {
					maxOccureCount=value;
					maxOccureChar=temp;
				}
				temp = charArray[i];
				value = 1;
			}
		}
		
		System.out.println("maxOccureCount:" +maxOccureCount);
		System.out.println("maxOccureChar:" +maxOccureChar);
	}

}
