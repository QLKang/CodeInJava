package leetcode.string.validpalindrome;

public class TestisPal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ValidPalindrome sol = new ValidPalindrome();
//		String s = "A man, a plan, a canal: Panama";
		String s = "1a2";
		boolean res = sol.isPalindrome(s);
		System.out.println(res);
	}

}
