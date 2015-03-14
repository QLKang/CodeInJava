package leetcode.string.substringwithconcatenationofallwords;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* 这个解法适用于L中单词有重复的情况,S的character不可以重复利用
 * 例如： "aaa", {"a", "a"}, return {0,1}
 * 
 * This is not Accepted code by leetcode
 * */
public class SolutionII {
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> res = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {	return res;	}

		int sLen = S.length(), wordCnt = L.length, wordLen = L[0].length();
		int substringLen = wordCnt * wordLen;
		int start = 0; // start index of substring
		// build a hashmap to store words in L <word, frequency>
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		for (int i = 0; i < wordCnt; i++) {
			if(!map1.containsKey(L[i])){
				map1.put(L[i], 1);
			}else{
				map1.put(L[i], map1.get(L[i])+1);
			}
		}

		while (start <= sLen - substringLen) {
			HashMap<String, Integer> map2 = new HashMap<String, Integer>(map1);
			String word = S.substring(start, start + wordLen);
			// check word in map or not
			if (!map2.containsKey(word)) {
				start++;
			} else {
				// String substring = S.substring(start, start + lenSubstring);	// check substring is consisted of words in L
				for (int j = start; j <= start + substringLen - wordLen; j=j+wordLen) {
					String word1 = S.substring(j, j + wordLen);
					if (!map2.containsKey(word1)) {
						start = j+1;
						break;
					} else {
						int f = map2.get(word1);
						if(f==0){
							start = j;
							break;
						}else{
							map2.put(word1, map2.get(word1)-1);
							if(j==start+substringLen-wordLen){
								res.add(start);
								start = start+substringLen;
								break;
							}
						}
					}
				} //
			}
		} // end for

		return res;
	} // end method
}
