package leetcode.dfs.permutationsii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*---Update: 02/11/2015---*/
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num){
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if(num==null || num.length==0)
			return res;
		
		List<Integer> subSol = new ArrayList<Integer>();
		boolean[] visited = new boolean[num.length];
		Arrays.sort(num);
		
		helper(num, subSol, res, visited);
		return res;
	}
	
	
	private boolean helper(int[] A, List<Integer> subSol, List<List<Integer>> res, boolean[] visited){
	
		// base case
		if(subSol.size()==A.length)
			return true;
		
		// recursive part
		for(int i=0; i<A.length; i++){
			if(i!=0 &&! visited[i-1] && A[i]==A[i-1]) 
				continue;
			
			if(!visited[i]){
				subSol.add(A[i]);
				visited[i] = true;
				if(helper(A, subSol, res, visited)){
					res.add(new ArrayList<Integer>(subSol));
				}
				subSol.remove(subSol.size()-1);
				visited[i]=false;
			}
		}
		
		return false;
	}

} // end class
