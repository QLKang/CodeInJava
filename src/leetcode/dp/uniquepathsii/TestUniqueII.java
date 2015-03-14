package leetcode.dp.uniquepathsii;

public class TestUniqueII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePathsII sol = new UniquePathsII();
		int[][] B = {
				{0,0,0,0,0},
				{0,0,1,0,0},
				{0,1,0,0,0},
				{0,0,0,1,0},
				{0,0,0,0,0}
				};
		int res = sol.uniquePathsWithObstacles(B);
		
		System.out.println(res);
	}

}
/*
 * test case [[1]] return 0;
 * [[0,1,0,0]] return 0;
 * [[1,0,0]] return 0;
 * [[0,0,0],[0,0,0],[0,0,1]] return 0
 * 
 */




