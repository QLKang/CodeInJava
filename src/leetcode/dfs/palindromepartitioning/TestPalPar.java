package leetcode.dfs.palindromepartitioning;

import java.util.List;

public class TestPalPar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioning sol = new PalindromePartitioning();
		String s = "aab";
		List<List<String>> res = sol.partition(s);
		System.out.println(res);
	}

}
