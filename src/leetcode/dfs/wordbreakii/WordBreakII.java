package leetcode.dfs.wordbreakii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*--Update: 02/10/2015----DP and backtracking--------*/
public class WordBreakII {
	List<String> wordBreak(String s, Set<String> dict) {
		List<String> res = new ArrayList<String>();
		StringBuilder subSol = new StringBuilder();
		
		int len = s.length();
		boolean[] isBreak = new boolean[len + 1]; // to record the search which has been executed once
		Arrays.fill(isBreak, true);
		
		helper(s, dict, 0, len, subSol, res, isBreak);
		return res;
	}

	void helper( String s, Set<String> dict, int start, int len, StringBuilder subSol, List<String> res, boolean[] isBreak) {
		if (start == len) {
			res.add(subSol.toString().trim());
			return;
		}
		for (int i = start; i < len; ++i) {
			String piece = s.substring(start, i+1);
			if (dict.contains(piece) && isBreak[i + 1]) // eliminate unnecessory search
			{
				subSol.append(piece).append(" ");
				int beforeChange = res.size();
				helper(s, dict, i+1, len, subSol, res, isBreak);
				if (res.size() == beforeChange) // if no solution, set the possible to false
					isBreak[i + 1] = false;
				subSol.delete(subSol.length()-piece.length()-1, subSol.length());
			}
		}
	}

} // end sol
