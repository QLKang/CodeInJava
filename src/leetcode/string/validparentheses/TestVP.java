package leetcode.string.validparentheses;

public class TestVP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParentheses sol = new ValidParentheses();
		String s = "(()[}]{}";
		boolean res = sol.isValid(s);
		System.out.println(res);
	}

}
