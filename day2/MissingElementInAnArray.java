package week1.day2;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		int Array1[] = {1,2,3,4,6,7,8};
	System.out.println("Missing number is from Array1:" +getmissingnumber(Array1)); 

		
	}

	public static int getmissingnumber(int[] array1) {
		int i, total;
		int n=array1.length;
		total = (n+1) * (n+2) /2;
		for (i=0; i<n; i++)
		total -= array1[i];
		return total;
	}

}
