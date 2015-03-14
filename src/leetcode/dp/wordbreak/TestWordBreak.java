package leetcode.dp.wordbreak;

import java.util.HashSet;
import java.util.Set;

public class TestWordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		
		WordBreak sol = new WordBreak();
		boolean res = sol.wordBreak(s, dict);
		System.out.println(res);
		
		
		
	}

} // end class
