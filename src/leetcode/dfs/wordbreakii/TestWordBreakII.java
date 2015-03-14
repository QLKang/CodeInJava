package leetcode.dfs.wordbreakii;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestWordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		String s = "catsanddog";
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
//		 String s = "aaaaaaaaa";
//	        Set<String> dict = new HashSet<String>();
//	        dict.add("bin");
//	        dict.add("apple");
//	        dict.add("app");
//	        dict.add("le");
//	        dict.add("aaaaaa");
//	        dict.add("aaaaa");
//	        dict.add("aaaa");
//	        dict.add("aaa");
//	        dict.add("aa");
//	        dict.add("a");
//	        dict.add("aaaaaaa");
//	        dict.add("aaaaaaaa");
//	        dict.add("aaaaaaaaa");
		
		WordBreakII sol = new WordBreakII();
		List<String> res = sol.wordBreak(s, dict);
		System.out.println(res);
	}

}
