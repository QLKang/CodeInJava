package leetcode.string.substringwithconcatenationofallwords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*这个解法使用与L中有重复单词的情况，并且S中的character可以重复利用
 * 例如： "aaa", {"a", "a"}, return {0, 1}
 * 
 * This is Accepted code by leetcode
 * */
public class SolutionIII {
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> res = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {
			return res;
		}

		int sLen = S.length(), wordCnt = L.length, wordLen = L[0].length();
		int substringLen = wordCnt * wordLen;
		// build a hashmap to store words in L <word, frequency>
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		for (int i = 0; i < wordCnt; i++) {
			if (!map1.containsKey(L[i])) {
				map1.put(L[i], 1);
			} else {
				map1.put(L[i], map1.get(L[i]) + 1);
			}
		}

		for(int i=0; i<= sLen - substringLen; i++) {
			if(isValidSubString(S, L, i, i+substringLen, map1)){
				res.add(i);
			}
		}
		
		return res;	
	} // end method


	private boolean isValidSubString(String S, String[] L, int start, int end, HashMap<String, Integer> map1){
		int wordLen = L[0].length();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>(map1);
		for(int i = start; i<=end-wordLen; i = i+wordLen){
			String currWord = S.substring(i, i+wordLen);
			if(!map2.containsKey(currWord)){
				return false;
			}else{
				int f = map2.get(currWord);
				if(f==0)
					return false;
				else{
					map2.put(currWord, f-1);
				}
			}
		}
		
		return true;
	}
} // end class
