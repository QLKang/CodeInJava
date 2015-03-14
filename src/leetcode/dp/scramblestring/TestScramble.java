package leetcode.dp.scramblestring;

public class TestScramble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ScrambleString sol = new ScrambleString();
//		String s1 = "great", s2 = "rgtae" ;
//		boolean res = sol.isScrambleDP(s1, s2);
//		String s1 = "abc", s2 = "cab";
		String s1 = "abcd", s2 = "bdac";
		boolean res = sol.isScramble(s1, s2);
		System.out.println(res);
	}
}
