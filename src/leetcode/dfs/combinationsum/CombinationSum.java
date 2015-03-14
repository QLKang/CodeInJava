package leetcode.dfs.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*--Update: Feb.15, 2015---*/
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates==null||candidates.length==0)
			return res;
		
		Arrays.sort(candidates);
		List<Integer> subList = new ArrayList<Integer>();
		helper(candidates, target, 0, new int[] {0}, subList, res);
		
		return res;
	}
	
	
	private void helper(int[] A, int t, int start, int[] sum, List<Integer> subList, List<List<Integer>> res){
		
		//base case
		if(sum[0]==t){
			res.add(new ArrayList<Integer>(subList));
			return;
		}
		if(sum[0]>t){
			return;
		}
		
		// recursive part
		for(int i=start; i<A.length; i++){
			
			if(sum[0]<t){
				subList.add(A[i]);
				sum[0]=sum[0]+A[i];
				helper(A, t, i, sum, subList, res);
				subList.remove(subList.size()-1);
				sum[0]=sum[0]-A[i];
			}
			
		}
		
	} // end
} // end
