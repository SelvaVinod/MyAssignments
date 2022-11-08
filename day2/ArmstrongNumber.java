package week1.day2;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int input=153;
		int calculated=0;
		int reminder, original, quotient;
		original=input;
		while(original >0) {
			reminder=original%10;
			quotient=original/10;
			original=quotient;
			calculated=calculated+(reminder*reminder*reminder);
			
		}

		if(input==calculated) {
			System.out.println("Number is Armstrong NUmber");
			
		}else {
			System.out.println("Number is not Armstrong Number");
		}
	}


	}

