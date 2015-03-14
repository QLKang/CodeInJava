package leetcode.dfs.restoreipaddresss;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s){
		List<String> res = new ArrayList<String>();
		if(s==null||s.length()<4||s.length()>12)
			return res;
		StringBuilder subSol = new StringBuilder();
		int[] count = {1};
		helper(s, 0, s.length()-1, subSol, res, count);
		return res;
	}
	
	
	private boolean helper(String s, int start, int end, StringBuilder subSol, List<String> res, int[] count){
		// base case
		if(start>end||count[0]>4)
			return false;
		if(count[0]==4 && isValidNum(s.substring(start))){
			subSol.append(s.substring(start)).append(".");
//			System.out.println("subSol:"+subSol);
			return true;
		}
		
		// recursive part
		
		for(int i= start; i<start+3 && i<s.length(); i++){
			String part = s.substring(start, i+1);
			if(isValidNum(part)){
				subSol.append(part).append(".");
//				System.out.println("subSol"+subSol);
				count[0]++;
//				System.out.println("count:"+count[0]);
				if(helper(s, i+1, end, subSol, res, count)){
					res.add(subSol.toString().substring(0, subSol.length()-1));
//					System.out.println("res:"+res);
				}
				count[0]--;
				int st = subSol.length()-part.length()-1;
				int ed = subSol.length();
				subSol.delete(st,ed);
//				System.out.println("subSol:"+subSol);
//				System.out.println("count:"+count[0]);
			}
		}
		return false;
	}
	
	
	private boolean isValidNum(String num){
		if(num==null||num.length()==0||num.length()>3)
			return false;
		int n = 0;
		for(int i=0; i<num.length(); i++){
			n = n*10+(num.charAt(i)-'0');
		}
		
		return n>=0 && n<=255;
	}
}
