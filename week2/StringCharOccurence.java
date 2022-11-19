package week2.day2;

public class StringCharOccurence {

	public static void main(String[] args) {
		
		String str = "welcome to chennai";
		char charOccur = 'e';
		int count=0;
		 
		 str=str.toLowerCase();
		 int strLen = str.length();
		 
		 char[] charArray1 = str.toCharArray();
		 
		 for(int i =0; i< strLen; i++ ) {
			 if(str.charAt(i) == 'e') {
				 count++;
			 }
		 }
		 
			 System.out.println("Number of " +charOccur+ " occurence in the given string is "+count);
				
		 }	 
		 

	}


