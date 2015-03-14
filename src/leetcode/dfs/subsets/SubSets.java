package leetcode.dfs.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {
/*--------soluiont1 is something wrong------*/
	public List<List<Integer>> subsets1(int[] S){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(S==null || S.length==0)
			return res;
		int start = 0, end = S.length-1;
		
		helper1(S, start, end, res);
		
		return res;
	} // end1
	
	
	private void helper1(int[] s, int start, int end, List<List<Integer>> res){
		if(start == end){
			ArrayList<Integer> subSet = new ArrayList<Integer>();
			subSet.add(s[start]);
			res.add(subSet);
			res.add(new ArrayList<Integer>());
			
		}
		else{
			helper1(s, start+1, end, res);
			List<List<Integer>> newRes =  new ArrayList<List<Integer>>(); 
//			for(int i=0; i<res.size();i++){
//				List<Integer> p2 = res.get(i);
			for(List<Integer> p2 : res){
				// new subset add s[start]
				List<Integer> newp2 = new ArrayList<Integer>(p2);
				newp2.add(s[start]);
				newRes.add(newp2);
				// new subset do not add s[start]
				newRes.add(p2);
			}
			res = new ArrayList<List<Integer>>(newRes);
		}
	} // end2
	
	/*----------solution2 is right------------------------*/
	
    public List<List<Integer>> subsets2(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(S==null || S.length==0)
			return res;
		int start = 0, end = S.length-1;
		Arrays.sort(S);
		return helper2(S, start, end, res);
	} // end1
	
	private List<List<Integer>> helper2(int[] s, int start, int end, List<List<Integer>> res){
		if(start == end){
			ArrayList<Integer> subSet = new ArrayList<Integer>();
			subSet.add(s[start]);
			res.add(subSet);
			res.add(new ArrayList<Integer>());
			return res;
		}
		else{
			List<List<Integer>> part2 = helper2(s, start+1, end, res);
			List<List<Integer>> newRes =  new ArrayList<List<Integer>>(); 
			for(List<Integer> p2 : part2){
				// new subset add s[start]
				List<Integer> newp2 = new ArrayList<Integer>(p2);
				newp2.add(0,s[start]);
				newRes.add(newp2);
				// new subset do not add s[start]
				newRes.add(p2);
			}
			return newRes;
		}
    }
	
	/*-------solution3----backtracking---------*/	
	public List<List<Integer>> subsets3(int[] S){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> sub = new ArrayList<Integer>();
		Arrays.sort(S);
		res.add(sub);
		helper3(res, sub, S, 0);
		return res;
	} // end subsets

	public void helper3(List<List<Integer>> res, List<Integer> sub, int[] s, int pos){
		for(int i=pos; i<s.length; i++){
			sub.add(s[i]);
			res.add(new ArrayList<Integer>(sub));
			helper3(res, sub, s, i+1);
			sub.remove(sub.size()-1);
		} // end for
	} // end helper
/*--------solution4----bit manipulation--------------*/
	
} // end class
