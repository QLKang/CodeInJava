package leetcode.string.textjustification;

import java.util.List;

public class TestTJ {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJustificationI sol = new TextJustificationI();
		String[] words = {"a","b","c","d","e"};
		int L = 3;
		List<String> res = sol.fullJustify(words, L);
		for(String s : res)
			System.out.println("\""+s+"\"");
		System.out.println();

	}

}
