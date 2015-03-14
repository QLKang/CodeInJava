package leetcode.string.textjustification;

import java.util.ArrayList;
import java.util.List;

public class TextJustificationI {
	public List<String> fullJustify(String[] words, int L) {
		// corner case
		List<String> res = new ArrayList<String>();
		if (words == null || L <= 0) {
			res.add("");
			return res;
		}

		if(words.length==0){
			StringBuilder sb = new StringBuilder();
			while(L > 0){
				sb.append(" ");
				L--;
			}
			res.add(sb.toString());
			return res;
		}
		
		int start = 0, end = words.length - 1;
		int i = 0;
		int wordLen = 0, rowLen = 0;
		while (i <= end) {

			if (words[i].length() > L)
				return null;

			rowLen = wordLen + i - start + words[i].length();
			if (rowLen <= L) {
				wordLen += words[i].length();
				i++;
			} else { // rowLen > L
			// i--;
			// wordLen = wordLen - words[i].length();
				int wordCnt = i - start;

				if (wordCnt == 1) {
					String line = generateLastLine(words, start, i - 1, L);
					res.add(line);
				} else if (wordCnt > 1) {
					String line = generateCommonLine(words, start, i - 1,
							wordCnt, L - wordLen);
					res.add(line);
				}

				start = i;
				wordLen = 0;
			} // end else

		} // end while

		String lastLine = generateLastLine(words, start, end, L);
		res.add(lastLine);

		return res;
	} // end method

	private String generateLastLine(String[] words, int start, int end, int L) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i <= end; i++) {
			sb.append(words[i]);
			if(sb.length() < L)
				sb.append(" ");
		}
		while (sb.length() < L) {
			sb.append(" ");
		}

		return sb.toString();
	}

	private String generateCommonLine(String[] words, int start, int end,
			int wordCnt, int totalSpaces) {
		StringBuilder sb = new StringBuilder();

		int eachSplit = totalSpaces / (wordCnt - 1);
		int extraSpace = totalSpaces % (wordCnt - 1);
		for (int i = start; i < end; i++) {
			sb.append(words[i]);
			int k = 0;
			while (k < eachSplit) {
				sb.append(" ");
				k++;
			}
			if (extraSpace > 0) {
				sb.append(" ");
				extraSpace--;
			}
		}
		sb.append(words[end]); 
		return sb.toString();
	}

} // end class

/* test case:
 * Input: [""], 2 return ["  "]
 * 
 */
