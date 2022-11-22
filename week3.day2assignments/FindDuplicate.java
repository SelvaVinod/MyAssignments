package week3Assignments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;



public class FindDuplicate {

	public static void main(String[] args) {

		 String text="abbaba"; 
        Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();         
        char[] charArray= text.toCharArray();         
        for(char ch : charArray)         {                          
        	map.put(ch, map.getOrDefault(ch,0)+1) ;               
        	}         
        System.out.println(map); 
        Set<Entry<Character,Integer>> entrySet = map.entrySet();
        char key=0;
        int maxOccur=0;
        
      for (Entry<Character, Integer> entry : entrySet) {
        	//if(value>0)\
        	if(entry.getValue()>0) {
        	key=entry.getKey();
        	maxOccur=entry.getValue();
			
		}
      
	}
      System.out.println("First duplicate character is : "+key);
      System.out.println("No of occurence: "+maxOccur);
	}
	}
	

