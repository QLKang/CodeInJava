package leetcode.string.simplifypath;

public class TestSP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplifyPath sol = new SimplifyPath();
		
//		String path = "/home/";
//		String path = "/a/./b/../../c/";
//		String path = "/home//foo/" ;
//		String path = "/../" ;
//		String path = "/home/work/hadoop";
//		String path = "/home/../hadoop/";
		String path = "//";
		String res = sol.simplifyPath(path);
		System.out.println(res);
	}

}
