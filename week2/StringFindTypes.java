package week2.day2;

public class StringFindTypes {

	public static void main(String[] args) {
		String test = "$$ Welcome to 2nd Class of Automation $$ ";
		
		int  letter = 0, space = 0, num = 0, specialChar = 0;
		//convert string to chararray
		char[] charArray1 = test.toCharArray();
		
		//length of the string
		int testLen = test.length();
		System.out.println("Total characters in a string is:" +testLen);
		for(int i=0; i< testLen; i++) {
			
				if(Character.isLetter(charArray1[i])) {
				letter++;
				}
				else if(Character.isDigit(charArray1[i])) {
					num++;
				}
				else if(Character.isSpaceChar(charArray1[i])) {
					space++;
				}
				else {
					specialChar++;
				}
		}
		 System.out.println("letter: " + letter);
			System.out.println("space: " + space);
			System.out.println("number: " + num);
			System.out.println("specialCharcter: " + specialChar);
	}
}