package leetcode.dfs.nqueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
	List<String[]> solveNQueens(int n) {
		List<String[]> res = new ArrayList<String[]>();
		if (n <= 0)
			return res;
		char[][] B = new char[n][n];
		for(int i=0; i<n;i++)
			Arrays.fill(B[i],'.');
		helper(B, 0, n, res);
		return res;
	}

	boolean helper(char[][] B, int currRow, int N, List<String[]> res) {
		// currRow is larger than N, finish the last row of Board.
		if (currRow >= N)
			return true;
		// in the current row, column j is from 0 to N-1
		for (int j = 0; j < N; j++) {
			if (isSafe(B, currRow, j)) {
				B[currRow][j] = 'Q';

				if (helper(B, currRow + 1, N, res)) {
					// res .add result
					String[] r1 = new String[N];
					for (int r = 0; r < N; r++) {
						StringBuilder sb = new StringBuilder();
						for (int c = 0; c < N; c++) {
							sb.append(B[r][c]);
						}
						r1[r] = sb.toString();
					}
					res.add(r1);
				}
				B[currRow][j] = '.';
			} 
		}
		return false;
	}

	boolean isSafe(char[][] B, int i, int j) {
		if (i < 0 || j < 0 || i >= B.length || j >= B.length)
			return false;
		int N = B.length;
		// check column
		for (int r = 0; r <= i; r++) {
			if (B[r][j] == 'Q')
				return false;
		}

		// check right up diagonal
		for (int r = i, c = j; r >= 0 && c < N; r--, c++) {
			if (B[r][c] == 'Q')
				return false;
		}

		// check left up diagonal
		for (int r = i, c = j; r >= 0 && c >= 0; r--, c--) {
			if (B[r][c] == 'Q')
				return false;
		}

		return true;
	}
	
}
