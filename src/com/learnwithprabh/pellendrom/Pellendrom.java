package com.learnwithprabh.pellendrom;

public class Pellendrom {

	
	public boolean checkThePellendrom(String input){
		 boolean isPellendrom=false;
		 
		 char[] charArray =input.trim().toCharArray();
         int size = charArray.length;
		 for ( int i=1; i<size ; i++){
			if(charArray[i-1]!= charArray[size-i]){
					 isPellendrom = false;
					 break;
				 }else{
					 isPellendrom = true; 
				 }
		 }
		return isPellendrom;
	}
}
