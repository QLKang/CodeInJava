package leetcode.dfs.lettercombinations;

import java.util.List;

public class TestComb {
	public static void main(String[] args){
		
		PhoneNumberLetterCombinations sol = new PhoneNumberLetterCombinations();
		String digs = "01203";
		List<String> res = sol.letterCombinations(digs);
		System.out.println(res);
		
	}
}
