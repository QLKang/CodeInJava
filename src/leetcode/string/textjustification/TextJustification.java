package leetcode.string.textjustification;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public List<String> fullJustify(String[] words, int L) {

		// corner case
		List<String> res = new ArrayList<String>();
		if (words == null || words.length == 0 || L <= 0)
			return res;

		int start = 0, end = words.length - 1;
		int i = start;
		int sumLen = 0;
		while (i <= end) {
			if (words[i].length() > L) {
				return null;
			} else {
				if (sumLen - 1 == L) {
					StringBuilder sb = new StringBuilder();
					for (int j = start; j <= i; j++) {
						sb.append(words[j]).append(" ");
					}
					res.add(sb.toString().trim());
					start = i;
					sumLen = 0;

				} else if (sumLen < L) {
					if (i == end) {
						StringBuilder sb = new StringBuilder();
						for (int k = start; i <= end; i++) {
							sb.append(words[k] + " ");
						}
						res.add(sb.toString().trim());
					} else {
						sumLen = sumLen + words[i].length() + 1;
						i++;
					}
				} else if (sumLen > L) {
					i--;
					int wordCnt = i - start;
					sumLen = sumLen - words[i].length() - 1;
					int wordLen = 0;
					int r = 0;
					int reminder = 0;
					StringBuilder sb = new StringBuilder();
					if (wordLen == 1) {
						sb.append(words[start]);
						int p = 0;
						while (p < L - words[start].length()) {
							sb.append(" ");
							p++;
						}
					} else {

						for (int j = start; j < i; j++) {
							wordLen = wordLen + words[j].length();
							r = (L - wordLen) / (wordCnt - 1);
							reminder = (L - wordLen) % (wordCnt - 1);
						}
						for (int j = start; j < i; j++) {
							sb.append(words[j]);
							int k = 0;
							while (k < r) {
								sb.append(" ");
								k++;
							}
							if (reminder > 0) {
								sb.append(" ");
								reminder--;
							}
						}
						res.add(sb.toString().trim());
						start = i;
						sumLen = 0;
					}
				} else if (sumLen == L) {
					StringBuilder sb = new StringBuilder();
					for (int j = start; j < i; j++) {
						if (j == start) {
							sb.append(words[j] + "  ");
						} else {
							sb.append(words[j]).append(" ");
						}
					} // end for
					res.add(sb.toString().trim());
					start = i;
					sumLen = 0;
				}

			} // else
		} // end while

		return res;
	} // end method

} // end class
