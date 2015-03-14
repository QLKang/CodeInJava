package leetcode.dfs.wordsearch;

public class Test {

	public static void main(String[] args) {
		WordSearch sol = new WordSearch();
		
		char[][] board = 	{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}; 
		String word = "ABCESEEEFS";
		boolean res = sol.exist(board, word);
		System.out.println(res);
			
	}

}


