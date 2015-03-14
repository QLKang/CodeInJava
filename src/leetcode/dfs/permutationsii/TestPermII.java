package leetcode.dfs.permutationsii;

import java.util.List;

public class TestPermII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PermutationsII sol = new PermutationsII();
		
		int[] num = {1,3,3};
		
		List<List<Integer>> res = sol.permuteUnique(num);
		
		System.out.println(res);
		
	}

}
/*test case
 * [-1,-1,3,-1] return [[-1, -1, -1, 3], [-1, -1, 3, -1], [-1, 3, -1, -1], [3, -1, -1, -1]]

 * [1,3,3] return [[1, 3, 3], [3, 1, 3], [3, 3, 1]]
 */