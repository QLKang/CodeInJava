package leetcode.dfs.generateparentheses;

import java.util.ArrayList;
import java.util.List;

/*update: Feb.15, 2015*/
public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {

		List<String> res = new ArrayList<String>();

		if (n <= 0)
			return res;

		StringBuilder sub = new StringBuilder();
		int[] cntL = { 0 }, cntR = { 0 };

		helper(n, sub, cntL, cntR, res);

		return res;
	}

	private void helper(int n, StringBuilder sub, int[] cntL, int[] cntR, List<String> res) {
		char[] brace = { '(', ')' };

		// base case
		if (cntR[0] == n) {
			res.add(sub.toString());
			return;
		}

		// recursive part
		for (int i = 0; i < 2; i++) {

			if ((cntL[0] == cntR[0] && i == 1))
				return;

			if (brace[i] == '(' && cntL[0] < n) {
				sub.append(brace[i]);
				cntL[0]++;
				helper(n, sub, cntL, cntR, res);
				sub.delete(sub.length() - 1, sub.length());
				cntL[0]--;
			} else if (brace[i] == ')' && cntR[0] < n) {
				sub.append(brace[i]);
				cntR[0]++;
				helper(n, sub, cntL, cntR, res);
				sub.delete(sub.length() - 1, sub.length());
				cntR[0]--;
			}

		}

	}

	public List<String> generateParenthesis2(int n) {
		List<String> res = new ArrayList<String>();
		String item = new String();

		if (n <= 0)
			return res;

		dfs(res, item, n, n);
		return res;
	}

	public void dfs(List<String> res, String item, int left, int right) {

		if (left > right)// deal with ")("
			return;

		if (left == 0 && right == 0) {
			res.add(new String(item));
			return;
		}

		if (left > 0)
			dfs(res, item + '(', left - 1, right);
		if (right > 0)
			dfs(res, item + ')', left, right - 1);
	} // end
} // end class
