package leetcode.dp.uniquebinarysearchtreeiii;


import java.util.List;

public class TestUniqueBSTII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UniqueBSTII sol  = new UniqueBSTII();
		int n = 3;
		List<TreeNode> res = sol.generateTrees(n);
		for(TreeNode node: res){
			System.out.println(node.val);
		}
		
	}

}
