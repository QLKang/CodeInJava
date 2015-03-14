package leetcode.dfs.combinations;

import java.util.List;

public class TestComb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Combinations sol = new Combinations();
		int n = 4, k =2;
		List<List<Integer>> res = sol.combine(n, k);
		System.out.println(res);
	}

}
