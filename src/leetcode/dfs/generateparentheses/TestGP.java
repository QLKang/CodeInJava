package leetcode.dfs.generateparentheses;

import java.util.List;

public class TestGP {
	
	public static void main(String[] args){
		GenerateParentheses sol = new GenerateParentheses();
		int n = 3;
		List<String> res = sol.generateParenthesis2(n);
		
		System.out.println(res);
	}
	
} // end class
