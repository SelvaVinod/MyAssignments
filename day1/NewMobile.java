package week1.day1;

public class NewMobile {
	
	String mobileBrandName = "Oppo";
	char mobileLogo = 'O';
	short noOfMobilePiece = 9;
	int modelNumber = 2022;
	long mobilelemiNumber = 23875644380603L;
	float mobilePrice = 23500;
	boolean isDamaged = false;
	
	public static void main(String[] args) {
		
		NewMobile Test = new NewMobile();
		
		System.out.println("mobileBrandName: "+Test.mobileBrandName);
		System.out.println("mobileLogo: "+Test.mobileLogo);
		System.out.println("noOfMobilePiece: "+Test.noOfMobilePiece);
		System.out.println("modelNumber: "+Test.modelNumber);
		System.out.println("mobilelemiNumber: "+Test.mobilelemiNumber);
		System.out.println("mobilePrice: "+Test.mobilePrice);
		System.out.println("isDamaged: "+Test.isDamaged);
	}
	
	
	

}
