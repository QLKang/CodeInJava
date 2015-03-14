package leetcode.dfs.wordsearch;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		// corner case
		if (word == null || word.length() == 0 || board == null
				|| board.length == 0 || board[0].length == 0)
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// for each position(i,j), we build a new visited arrays, which all falses
				boolean[][] visited = new boolean[board.length][board[0].length];
				// initialize the first visited point as true
				visited[i][j]=true;
				
				if (helper(board, i, j, word, 0, visited))
					return true;
			}
		}

		return false;
	}

	private boolean helper(char[][] B, int starti, int startj, String word, int wordId, boolean[][] visited) {

		// base case
//		if (wordId == word.length()) {
//			return true;
//		}
		if(wordId ==word.length()-1 && B[starti][startj]==word.charAt(wordId))
			return true;
		
		if (B[starti][startj] != word.charAt(wordId)) {
			return false;
		}

//		visited[starti][startj] = true;

		int[] L = tryLeft(B, starti, startj);
		int[] R = tryRight(B, starti, startj);
		int[] U = tryUp(B, starti, startj);
		int[] D = tryDown(B, starti, startj);
		// recursive part
		if (L != null && !visited[L[0]][L[1]]) {
			visited[L[0]][L[1]] = true;
			if (helper(B, L[0], L[1], word, wordId + 1, visited)) {
				return true;
			}
			visited[L[0]][L[1]] = false;
		}
		if (R != null && !visited[R[0]][R[1]]) {
			visited[R[0]][R[1]] = true;
			if (helper(B, R[0], R[1], word, wordId + 1, visited)) {
				return true;
			}
			visited[R[0]][R[1]] = false;

		} 
		if (U != null && !visited[U[0]][U[1]]) {
			visited[U[0]][U[1]] = true;
			if (helper(B, U[0], U[1], word, wordId + 1, visited)) {
				return true;
			}
			visited[U[0]][U[1]] = false;
		}
		if (D != null && !visited[D[0]][D[1]]) {
			visited[D[0]][D[1]] = true;
			if (helper(B, D[0], D[1], word, wordId + 1, visited)) {
				return true;
			}
			visited[D[0]][D[1]] = false;
		}

		return false;
	} // end

	private int[] tryLeft(char[][] B, int i, int j) {
		if (j <= 0)
			return null;
		return new int[] { i, j-1 };
	}

	private int[] tryRight(char[][] B, int i, int j) {
		if (j >= B[0].length - 1)
			return null;
		return new int[] { i, j+1 };
	}

	private int[] tryUp(char[][] B, int i, int j) {
		if (i <= 0)
			return null;
		return new int[] { i-1, j };
	}

	private int[] tryDown(char[][] B, int i, int j) {
		if (i >= B.length - 1)
			return null;
		return new int[] { i+1, j };
	}

} // end class

