package week3.day2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniqueSet {

	public static void main(String[] args) {
		String companyName = "Google";
		
		char[] charArray= companyName.toCharArray();
		
		Set<String> uniqueSet = new HashSet<String>();
		
        for (int i = 0; i < charArray.length; i++) {
        	String k = String.valueOf(charArray[i]);
        	//System.out.println(uniqueSet.add(k));
        	uniqueSet.add(k);
			
		}
        System.out.println(uniqueSet);
	}

}
