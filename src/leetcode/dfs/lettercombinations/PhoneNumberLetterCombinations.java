package leetcode.dfs.lettercombinations;

import java.util.ArrayList;
import java.util.List;
/*---Update: 02/12/2015-----backtracking---------*/
public class PhoneNumberLetterCombinations {
	
	public List<String> letterCombinations(String digits){
		
		List<String> res = new ArrayList<String>();
		String[] dict = {" ", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		StringBuilder sub = new StringBuilder();
		
		helper(digits, 0, digits.length()-1, sub, res, dict);
		
		return res;
	}
	
	
	private void helper(String digs, int start, int end, StringBuilder sub, List<String> res, String[] dict){
		
		// base case
		if(start>end){
			res.add(sub.toString());
			return;
		}
		
		// recursive part
		char currChar = digs.charAt(start);
		String currStr = dict[currChar-'0'];
		int len = currStr.length();
		
		if(len==0){
			helper(digs, start+1, end, sub, res, dict);
		}else{
			
			for(int i=0; i<len; i++){
				sub.append(currStr.charAt(i));
				helper(digs, start+1, end, sub, res, dict);
				sub.delete(sub.length()-1, sub.length());
			}
			
		}
		
	} // end
	
}
