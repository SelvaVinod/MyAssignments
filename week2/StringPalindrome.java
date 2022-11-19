package week2.day2;

public class StringPalindrome {

	public static void main(String[] args) {
		String str = "madam";
		String revStr = "";
		int strLength = str.length();
		for(int i= (strLength - 1) ; i>=0; --i) {
			revStr = revStr + str.charAt(i);
		}
		System.out.println("Reverse String is: "+revStr);
		if (str.equalsIgnoreCase(revStr))
				System.out.println("The given string is Palindrome");
		else
			System.out.println("The given string is not Palindrome");

	}

}
