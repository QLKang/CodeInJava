package leetcode.dfs.palindromepartitioning;

import java.util.ArrayList;
import java.util.List;
/*----Update 02/12/2015---backtracking-----*/
public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		
		List<List<String>> res = new ArrayList<List<String>>();
		
		if(s==null||s=="") return res;
		
		List<String> subList = new ArrayList<String>();
		
		helper2(s, 0, s.length()-1, subList, res);

		return res;
	}
	
	
	private boolean helper2(String s, int start, int end, List<String> subList, List<List<String>> res){
		if(start > end){
			res.add(new ArrayList<String>(subList));
			return true;
		}
	
		for(int i= start; i<=end; i++){
			String str1 = s.substring(start, i+1);
			
			if(isPalindrome(str1)){
				subList.add(str1);
				helper2(s, i+1, end, subList, res);
				subList.remove(subList.size()-1);
			}
			
		}
		
		return false;
	}
	
	
	private boolean isPalindrome(String s){
		if(s==null||s=="")
			return false;
		int i=0, j=s.length()-1;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		
		return true;
	} // end
	
} // end class

//	private List<List<String>> helper(String s, int start, int end, List<String> subList, List<List<String>> res){
//		
//		if(start > end)
//			return null;
//		// recursive part
//		for(int i=start; i<=end; i++){
//			String str1 = s.substring(start, i+1);
//			if(isPalindrome(str1)){
//				List<List<String>> part2Lists = helper(s, i+1, end, subList, res);
//				if(part2Lists!=null){
//					for(List<String> list: part2Lists){
//						list.add(0,str1);
//					}
//				}else{
//					subList.add(str1);
//					res.add(subList);
//				}
//				
//			}
//		}
//		
//		return res;
//	} // end
//	