package leetcode.dfs.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*---Update: 02/11/2015---*/
public class Permutations {
	public List<List<Integer>> permute(int[] num){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num==null||num.length==0){
			return null;
		}
		
		List<Integer> subSol = new ArrayList<Integer>();
		boolean[] visited = new boolean[num.length]; 
		Arrays.sort(num);
		helper(num, subSol, res, visited);
		
		return res;
	} // end

	private boolean helper(int[] A, List<Integer> subSol, List<List<Integer>> res, boolean[] visited) {

		// base case
		if(subSol.size()==A.length){
			return true;
		}
		
		// recursive part
		for(int i=0; i<A.length; i++){
			if(!visited[i]){
				subSol.add(A[i]);
				visited[i]=true;
				if(helper(A, subSol, res, visited)){
					res.add(new ArrayList<Integer>(subSol));
				}
				subSol.remove(subSol.size()-1);
				visited[i]=false;
			}
		}
		return false;
	} // end helper
} // end class
