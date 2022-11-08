package week1.day2;

public class FindIntersection {

	public static void main(String[] args) {
		int Array1[] = {3,2,11,4,6,7};
		int Array2[] = {1,2,8,4,9,7};
		System.out.println("Intersection of the two arrays");
		
		for(int i=0; i<Array1.length; i++) 
		for(int j=0; j<Array2.length; j++)	
			if(Array1[i] == Array2[j] ) {
				System.out.println(Array2[j]);
			}
		}
		}
		
		

	


