package week2.day2;

import java.util.Arrays;

public class StringReverseEvenWords {

	public static void main(String[] args) {
		String test = "I am a software tester"; 
		String revStr="";
		String outputString ="";
		String[] sp = test.split(" ");
		System.out.println(Arrays.toString(sp));
		//System.out.println(sp);
		
		
		for(int i=0;i< sp.length;i++) {
			if(i%2 !=0) {
				//System.out.println("Even words in the string is" +sp[i]);
				char[] charArray = sp[i].toCharArray();
				
				for(int j=sp[i].length() -1; j>=0;j--) {
					revStr = revStr + charArray[j]; 
					
				}
				outputString = outputString + revStr+" ";
			}
			else
				outputString = outputString+sp[i]+" ";
		}
		System.out.println(outputString);
	
	}

}
