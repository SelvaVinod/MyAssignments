package week1.day2;

public class ConvertANegativeNumberToPositiveNumber {

	public static void main(String[] args) {
		int number = -40;
		
		if (number<0) {
			number = number * (-1);
			System.out.println("Negative Number Converted To Positive Number is:" +number);
		}		
			else if (number>0) {
				number = number * (-1);
				System.out.println("Postive Number Converted to Negative Number is:" +number);
				
			}
		}
		

	}


