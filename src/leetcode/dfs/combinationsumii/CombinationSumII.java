package leetcode.dfs.combinationsumii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num==null||num.length==0)
			return res;
		
		Arrays.sort(num);
		List<Integer> subList = new ArrayList<Integer>();
		helper(num, target, new int[]{0}, 0, subList, res);
		
		return res;
	} // end
	
	
	private void helper(int[] A, int t, int[] sum, int start, List<Integer> subList, List<List<Integer>> res){
		// base case
		if(sum[0]==t){
			res.add(new ArrayList<Integer>(subList));
		}
		if(sum[0]>t)
			return;
		
		// recursive part
		for(int i = start; i<A.length; i++){
			if(i!=start && A[i]==A[i-1])
				continue;
			subList.add(A[i]);
			sum[0] = sum[0]+A[i];
			helper(A, t, sum, i+1, subList, res);
			subList.remove(subList.size()-1);
			sum[0]=sum[0]-A[i];
		}	
		
	} // end
	
}
