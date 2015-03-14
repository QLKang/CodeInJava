package leetcode.string.substringwithconcatenationofallwords;

import java.util.List;

public class TestConcatenation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "barfoothefoofoobar";  //[0, 12]
//		String s = "barfoothefoofdbarfoo"; //[0, 14]
//		String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
//		String[] L = {"fooo","barr","wing","ding","wing"};
//		String[] L = {"foo", "bar"};
		String s = "foobarfoothefoofdbarfoofoo";  
		String[] L = {"foo", "bar", "foo"};
		SolutionIII sol = new SolutionIII();
		List<Integer> res = sol.findSubstring(s, L);
		System.out.println(res);
		
	}

}

/*
 * test case :  
 * s = "barfoothefoofoobar", L = {"foo", "bar"}, return [0, 12]
 * s = "barfoothefoofdbarfoo", L = {"foo", "bar"}, return [0, 14]
 * s = "lingmindraboofooowingdingbarrwingmonkeypoundcake", L = {"fooo","barr","wing","ding","wing"}, return [13]
 * s = "foobarfoothefoofdbarfoofoo", L = {"foo", "bar", "foo"}, return [0, 17]
 * 
 * 
 * "aaa", ["a","a"]
Output:	[0]
Expected:	[0,1]
 */
 