package leetcode.dfs.subsets;

import java.util.List;

public class TestSubSets {

	public static void main(String[] args){
		SubSets ss = new SubSets();
		int[] S = {1,2,3};
		List<List<Integer>> res = ss.subsets3(S);
		for(List<Integer> sub : res){
			System.out.println(sub);
		}
		
	}
	
	
}
