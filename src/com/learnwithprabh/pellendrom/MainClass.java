package com.learnwithprabh.pellendrom;
import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	while(MainClass.wantToCheckMore()){
		System.out.println(" Enter the Input : ");
		Scanner scan1 = new Scanner(System.in);
		String input1 = scan1.next();
		Pellendrom  p = new Pellendrom();
        System.out.println(input1+" is pellendrom : " +p.checkThePellendrom(input1) );
	}
		System.out.println("Ok B Bye :) ");
	}
	
public static boolean wantToCheckMore(){
	System.out.println(" DO you want to  get the  new Input : y/n");
	Scanner scan = new Scanner(System.in);
	String input=scan.next();
	if(input.trim().equalsIgnoreCase("y")){
		return true;
	}else{
		return false;
	}
}
}
