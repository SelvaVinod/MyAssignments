package week3.day2;

import java.util.HashMap;
import java.util.Map;

public class MapNumOccurence {

	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 2, 5};
		//1 =2, 2=2,3=1,5=1
		Map<Integer, Integer> occ= new HashMap<Integer,Integer>();
		
//		for (Entry<Integer, Integer> entry : map.entrySet()) {
//            if(entry.getValue() == 1) {
//                System.out.print(entry.getKey());
//            }
//        }
		
		for (int i = 0; i < nums.length; i++) {
			if(occ.containsKey(nums[i])) {
				int value= occ.get(nums[i]);
				occ.put(nums[i], value+1);
			}
			else {
				occ.put(nums[i], 1);
			}
			
		}		
			System.out.println(occ);
	}
	

}
