package leetcode.string.substringwithconcatenationofallwords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 这个解法适合L中的单词没有重复的情况 . 并且S中用过的character不可以重复利用
 * eg。"aba", {"a", "b"}, return 0.
 * This is not Accepted code by leetcode
 * */
public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String S, String[] L) {

		List<Integer> res = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {
			return res;
		}

		int lenS = S.length(), lenL = L.length, lenWord = L[0].length();
		int lenSubstring = lenL * lenWord;
		int start = 0; // start index of substring
		int freq = 0;

		// build a hashmap to store words in L <word, frequency>
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < lenL; i++) {
			map.put(L[i], 0);
		}

		while (start <= lenS - lenSubstring) {

			String word = S.substring(start, start + lenWord);

			// check word in map or not
			if (!map.containsKey(word)) {
				start++;

			} else {
				// String substring = S.substring(start, start + lenSubstring);
				// check substring is consisted of words in L
				for (int j = start; j <= start + lenSubstring - lenWord; j=j+lenWord) {
					String word1 = S.substring(j, j + lenWord);
					if (!map.containsKey(word1)) {
						for (int k = 0; k < lenL; k++) {
							map.put(L[k], freq);
						}
						start = j+1;
						break;
					} else {
						int f = map.get(word1);
						if (f == freq) {
							map.put(word1, freq + 1);
							if (j == start + lenSubstring - lenWord) {
								freq++;
								res.add(start);
								start = start + lenSubstring;
								break;
							}
						} else { // f!=freq
							start = j;
							for (int k = 0; k < lenL; k++) {
								map.put(L[k], freq);
							}
							break;
						}
					}
				}
			}
		} // end for

		return res;
	} // end method

}  // end class
