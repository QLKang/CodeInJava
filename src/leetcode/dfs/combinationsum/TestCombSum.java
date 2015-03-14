package leetcode.dfs.combinationsum;

import java.util.List;

public class TestCombSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum sol = new CombinationSum();
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> res = sol.combinationSum(candidates, target);
		System.out.println(res);
	}

}
