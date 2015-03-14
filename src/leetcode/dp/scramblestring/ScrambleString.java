package leetcode.dp.scramblestring;

import java.util.Arrays;

/*-SolII: Update 02/17/2015. DP. Time O(n^4), space O(n^3)--*/

public class ScrambleString {

	public boolean isScramble(String s1, String s2) {

		if (s1 == null || s2 == null || s1 == "" || s2 == "")
			return false;

		int len = s1.length(), len2 = s2.length();

		if (len != len2)
			return false;

		char[] ss1 = s1.toCharArray(), ss2 = s2.toCharArray();
		
		Arrays.sort(ss1);
		Arrays.sort(ss2);
		
		for (int i = 0; i < len; i++) {
			if (ss1[i] != ss2[i])
				return false;
		}

		boolean[][][] cache = new boolean[len+1][len][len];
		
		char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (arr1[i] == arr2[j])
					cache[1][i][j] = true;
			}
		}

		for (int subLen = 2; subLen <= len; subLen++) {
			for (int i = 0; i <= len - subLen; i++) {
				for (int j = 0; j <= len - subLen; j++) {
					for(int split =1; split<subLen; split++){
						cache[subLen][i][j] = cache[subLen][i][j] 
								|| cache[split][i][j] && cache[subLen-split][i+split][j+split]
								|| cache[split][i][j+subLen-split] && cache[subLen-split][i+split][j];
					}
				}
			}
		}

		return cache[len][0][0];
	}

} // end class
