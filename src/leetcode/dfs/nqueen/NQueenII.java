package leetcode.dfs.nqueen;

public class NQueenII {
	public static int totalNQueens(int n){
		int[] res = {0};
		if(n<=0) return res[0];
		char[][] B = new char[n][n];
		int[] Qposition = new int[n];
		helper(B, n, 0, res, Qposition);
		return res[0];
	}
	
	private static boolean helper(char[][] B, int n, int currRow, int[] res, int[] Qposition){
		// base case
		if(currRow>=n){
			return true;
		}
		// recursive call
		for(int j=0; j<n; j++){
			if(isValid(B, currRow, j, Qposition)){
//				System.out.println("\'"+B[currRow][j]+"\'");
				B[currRow][j]='Q';
				Qposition[currRow]=j;
				if(helper(B, n, currRow+1, res, Qposition)){
					res[0]++;
				}
				B[currRow][j]=' ';
			}
		}
		
		return false;
	}
	
	private static boolean isValid(char[][] B, int currRow, int j, int[] Qposition){
		for(int i=0; i<currRow; i++){
			if(j==Qposition[i]) return false;
			if(currRow-i==j-Qposition[i]||i-currRow==j-Qposition[i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		NQueenII sol = new NQueenII();
		int n=8;
		int res = totalNQueens(n);
		System.out.println(res);
	}

}
