package leetcode.dfs.combinations;

import java.util.ArrayList;
import java.util.List;
/*----Update: Feb.15, 2015----*/
public class Combinations {
	public List<List<Integer>> combine(int n, int k){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(n<k||n<0||k<0)
			return res;
		
		List<Integer> subList = new ArrayList<Integer>();
		
		helper(n, k, 1, subList, res);
		return res;
	}
	
	
	private void helper(int n, int k, int start, List<Integer> subList, List<List<Integer>> res){
		
		// base case
		if(subList.size()==k){
			res.add(new ArrayList<Integer>(subList));
			return ;
		}
		
		// recursive part
		for(int i=start; i<=n; i++){
			subList.add(i);
			helper(n, k, i+1, subList, res);
			subList.remove(subList.size()-1);
		}
		
	}

} // end
