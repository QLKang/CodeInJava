package leetcode.dfs.restoreipaddresss;

import java.util.List;

public class TestRestore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestoreIPAddresses sol = new RestoreIPAddresses();
		String s = "010010";
		List<String> res = sol.restoreIpAddresses(s);
		System.out.println(res);
		
//		String s = "0123456";
//		String res = s.substring(8, 1);
//		System.out.println("|"+res+"|");
		
	}

}
