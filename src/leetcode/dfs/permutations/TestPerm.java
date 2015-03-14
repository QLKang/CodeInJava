package leetcode.dfs.permutations;

import java.util.List;

public class TestPerm {

	public static void main(String[] args){
		
		Permutations sol = new Permutations();
		int[] num = {1,2,3};
		List<List<Integer>> res = sol.permute(num);
		System.out.println(res);
		
	} // end main
} // end class
