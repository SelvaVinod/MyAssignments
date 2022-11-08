package week1.day2;

import java.util.Arrays;

public class SecondLargestArray {

	public static void main(String[] args) {
		int[] arr = {3,2,11,4,6,7};
		System.out.println(arr[1]);
		
		int noOfData=arr.length;
		System.out.println(noOfData);
		
		Arrays.sort(arr);
		for (int i=0; i < noOfData ;i++) 
			System.out.println(arr[i]); 
		
		System.out.println(arr[arr.length-2]); 

	}



}
	

	


