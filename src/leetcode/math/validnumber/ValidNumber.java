package leetcode.math.validnumber;

/* Update: 02/19/2015  this is uncorrected code
 * Test: Input:	"3." , return	true
 * intput " ", return false
 * ".", return false
 * "..", return false
 * "2e0", return fasle
 * "..2", return false;
 * */
public class ValidNumber {
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0)
			return false;

		s = s.toLowerCase();
		s = s.trim();
		if (s.length() == 0)
			return false;
		if (s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '.')
			s = s.substring(1);

		if (s.length() == 0)
			return false;

		if (s.charAt(0) == 'e' || s.charAt(s.length() - 1) == 'e')
			return false;

		String[] arrPoint = s.split("\\.");
		int pointLen = arrPoint.length;
		if (pointLen == 0)
			return false;
		if (pointLen > 2) {
			return false;
		} else {
			if (pointLen == 2 && (!isNum(arrPoint[0]) || !isNum(arrPoint[1])))
				return false;
		}

		String[] arrE = s.split("e");
		int eLen = arrE.length;
		if (eLen > 2) {
			return false;
		} else {
			if (eLen == 2 && (!isNum(arrE[0]) || !isNum(arrE[1])))
				return false;
		}

		return true;
	}

	private boolean isNum(String s) {
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9')
				return false;
		}
		return true;
	}

}
