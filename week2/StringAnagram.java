package week2.day2;

import java.util.Arrays;

public class StringAnagram {

	public static void main(String[] args) {
		String text1= "stops";
		String text2= "potss";
		
		//convert string To Lower case
		text1 = text1.toLowerCase();
		text2 = text2.toLowerCase();
		
		int str1= text1.length();
		int str2 = text2.length();
		
		if(str1 == str2) {
			
			char[] charArray1 = text1.toCharArray();
			char[] charArray2 = text2.toCharArray();
			
			Arrays.sort(charArray1);
			Arrays.sort(charArray2);
			
			boolean result = Arrays.equals(charArray1, charArray2);
			if(result) 
				System.out.println(text1+" and "+ text2 + " are Anagram");
			else
				System.out.println(text1+" and "+ text2 + "are not Anagram");
		}else {
			System.out.println(text1+" and "+ text2 + "are not Anagram"); 
				
			}
			

	}

}
