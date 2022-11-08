package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {	
		
		int count = 8,fn1 = 0, fn2 = 1, i,fn3;
		
		System.out.println(fn1);
		System.out.println(fn2);
		
		for(i=2;i<count;i++) {
			
			fn3 = fn1+fn2;
			System.out.println(fn3);
			fn1 = fn2;
			fn2 = fn3;
			
		}
		
				
	}

		
		
	}
		