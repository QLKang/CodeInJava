package leetcode.dp.triangle;

import java.util.ArrayList;
import java.util.List;
/*Update: Feb. 16, 2015 top to down. But down to top is better.*/
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle ){		
		if(triangle==null || triangle.size()==0 || triangle.get(0).size()==0)
			return 0;
		
		ArrayList<Integer> lastList = new ArrayList<Integer>();
		lastList.add(triangle.get(0).get(0));
		
		for(int i = 1; i<triangle.size(); i++){
			ArrayList<Integer> currList = new ArrayList<Integer>();
			List<Integer> currLevel = triangle.get(i);
			for(int j = 0; j<currLevel.size(); j++){
				int currVal = 0;
				if(j==0){
					currVal = currLevel.get(j)+lastList.get(j);
				} else if(j==currLevel.size()-1){ 
					currVal = currLevel.get(j)+lastList.get(j-1);
				} else {
					currVal = currLevel.get(j) + Math.min(lastList.get(j), lastList.get(j-1));
				}
				
				currList.add(currVal);
			}
			lastList = currList;
		}
		int min = Integer.MAX_VALUE;
		for(Integer ii: lastList){
			min = Math.min(min, ii);
		}
		
		return min;
	} // end 	
} // end 
