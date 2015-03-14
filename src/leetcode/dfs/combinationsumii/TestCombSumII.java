package leetcode.dfs.combinationsumii;

import java.util.List;

public class TestCombSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CombinationSumII sol = new CombinationSumII();
		int[] num = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> res = sol.combinationSum2(num, target);
		System.out.println(res);
	}

}
