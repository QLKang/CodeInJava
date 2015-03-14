package leetcode.dp.uniquepaths;

public class UniquePaths {

	public int uniquePaths(int m, int n) {

		if (m <= 0 || n <= 0)
			return 0;

//		return helper1(m - 1, n - 1);
		int[][] mat = new int[m][n];
		return helper2(m-1, n-1, mat);
	} // end

	private int helper1(int M, int N) {
		if (M == 0 || N == 0)
			return 1;

		return helper1(M - 1, N) + helper1(M, N - 1);
	} // end

	private int helper2(int M, int N, int[][] mat) {
	
		if (M == 0 || N == 0)
			return 1;
		if (mat[M][N] != 0)
			return mat[M][N];

		mat[M][N] = helper2(M - 1, N, mat) + helper2(M, N - 1, mat);
		return mat[M][N];
	
	}

} // end class
