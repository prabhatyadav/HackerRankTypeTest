package com.learnwithprabh.cupcake;

public class MainCupCake {

	public static void main(String[] args) {
		totalCupCakeCount(10,2,2); //ans =9
	}

	public static int totalCupCakeCount(int budget_n, int cupcake_cost_c, int free_wrap_cont_n) {
		int unused_wrap = 0;
		int count_of_wrap = budget_n / cupcake_cost_c;
		int result = count_of_wrap;

		while (count_of_wrap >= free_wrap_cont_n) {
			result = result + (count_of_wrap + unused_wrap) / free_wrap_cont_n;
			unused_wrap = (count_of_wrap + unused_wrap) % free_wrap_cont_n;
			count_of_wrap = (count_of_wrap + unused_wrap) / free_wrap_cont_n;
		}
		
		System.out.println(result);
		return result;
	}

}
