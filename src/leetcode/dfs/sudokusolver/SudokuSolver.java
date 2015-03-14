package leetcode.dfs.sudokusolver;

public class SudokuSolver {
	public void solveSudoku(char[][] board){
		
		if(board==null||board.length==0||board[0].length==0)
			return ;
		
		int row=0, col=0; // calculation starts from (0,0)
		helper(board, row, col);

		return; 
	} // end 1
	
	private boolean helper(char[][] B, int row, int col){
		
		// base case
		if(row>8)
			return true;
		
		if(col>8)
			return helper(B, row+1, 0);
		
		// recursive part
		if(B[row][col]=='.'){
			// try number 1 to 9 one by one. note '1' to '9' is character
			for(char ch = '1'; ch <='9'; ch++){
				
				B[row][col]=ch;
				
				if(isValid(B, row, col)){
					if(helper(B, row, col+1))
						return true;
				}
		
				B[row][col]='.';
			}
		
		} else {
			
			if(helper(B, row, col+1))
				return true;
		}
		
		return false;
	} // end2
	
	private boolean isValid(char[][] B, int row, int col){
		
		return isValidRow(B, row, col)&&isValidCol(B, row, col)&&isValidBox(B, row, col);
	}
	
	private boolean isValidRow(char[][] B, int row, int col){
		for(int j=0; j<9; j++){
			if(j!=col&&B[row][j]==B[row][col])
				return false;
		}
		return true;
	}

	private boolean isValidCol(char[][] B, int row, int col){
		for(int i=0; i<9; i++){
			if(i!=row&&B[i][col]==B[row][col])
				return false;
		}
		return true;
	}

	private boolean isValidBox(char[][] B, int row, int col){
		
		for(int i = row/3*3; i<row/3*3+3; i++ ){
			for(int j = col/3*3; j<col/3*3+3; j++){
				if(i!=row && j!=col && B[i][j]==B[row][col])
					return false;
			}
		}
		
		return true;
	}
} // end class
