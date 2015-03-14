package leetcode.string.zigzagconversion;

public class TestZigZag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigZagConversion sol = new ZigZagConversion();
		String s = "xztqrsvbspkyhsenbppkqtpddbuotbbqcwivrf"; //38
//		String s = "abcdefghijklmnopqr";
//		int nRows = 5;
		int nRows = 38;
		String res = sol.convert2(s, nRows);
		System.out.println(res);
	}

}
