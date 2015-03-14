package leetcode.dp.wordbreak;

import java.util.Set;

/*--------- Update: Feb.15, 2015 --------*/
public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict){
		
		if(s==null||s==""||dict==null||dict.size()==0)
			return false;
		boolean[] flag = new boolean[s.length()+1];
		flag[0] = true;
		
		for(int i=0; i<s.length(); i++){
			for(int j=0; j<=i; j++){
				if(flag[j]==true && dict.contains(s.substring(j, i+1))){
					flag[i+1]=true;
					break;
				}
			}
		}
		
		return flag[s.length()]==true;
	}
	
} // end
