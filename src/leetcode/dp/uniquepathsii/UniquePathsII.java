package leetcode.dp.uniquepathsii;


/*-------SolII: Update Feb.15, 2015, DP------*/
public class UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] mat = new int[m][n];

		if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
			return 0;
		return helper(obstacleGrid, m - 1, n - 1, mat);
	}

	private int helper(int[][] B, int M, int N, int[][] mat) {

		if (M == 0 && N == 0)
			return 1;
		if (M < 0 || N < 0)
			return 0;

		if (B[M][N] == 1)
			return 0;

		if (mat[M][N] != 0) {
			return mat[M][N];
		}

		mat[M][N] = helper(B, M - 1, N, mat) + helper(B, M, N - 1, mat);
		return mat[M][N];
	}

}
