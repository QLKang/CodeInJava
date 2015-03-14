package leetcode.string.atoi;

public class TestAtoI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringToInteger sol = new StringToInteger();
		String s = "    -00134";
		int res = sol.atoi(s);
		
		System.out.println("\""+res+"\"");
	}

}
