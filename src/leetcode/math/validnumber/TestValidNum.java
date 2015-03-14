package leetcode.math.validnumber;

public class TestValidNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1 = "123.45e6";
//		String[] arr1 = s1.split("\\.");
//		String[] arr2 = s1.split("e");
		
//		s1 = s1.substring(1);
		
		ValidNumber sol = new ValidNumber();
		
		String s = "2e0";
		boolean res = sol.isNumber(s);
		System.out.println(res);
		
	}

}
