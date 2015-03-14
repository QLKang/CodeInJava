package leetcode.string.atoi;

public class StringToInteger {

	public int atoi(String s) {

		int res = 0;
		if (s == null || s.length() == 0)
			return res;

		int sign = 1;

		s = s.trim();
		s = s.toLowerCase();
		if (s == "")
			return res;

		for (int i = 0; i < s.length(); i++) {
		if (i==0 && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			if (s.charAt(0) == '-')
				sign = -1;
		} else {
				int cToI = s.charAt(i) - '0';

				if (cToI < 0 || cToI > 9)
					return sign==-1? -res:res;

				if (sign == 1 && res > (Integer.MAX_VALUE - cToI) / 10) {
					return Integer.MAX_VALUE;
				}
				if (sign == -1 && res > -((Integer.MIN_VALUE + cToI) / 10)){
					return Integer.MIN_VALUE;
				}

				res = res * 10 + cToI;
			}
		}

		return sign==-1? -res : res;
	} // end
} // end class
