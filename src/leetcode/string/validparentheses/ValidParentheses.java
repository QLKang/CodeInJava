package leetcode.string.validparentheses;

import java.util.Stack;
/*-Update 02/19/15--*/
public class ValidParentheses {
	
	public boolean isValid(String s){
		if(s==null||s=="")
			return false;
		int len = s.length();
		if(len%2==1)
			return false;
		Stack<Character> stk = new Stack<Character>();
		for(int i=0; i<len; i++){
			if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
				stk.push(s.charAt(i));
			}else{
				if(s.charAt(i)==')'){
					if(stk.isEmpty() || stk.pop()!='('){
						return false;
					}
				} else if(s.charAt(i)==']'){
					if(stk.isEmpty() || stk.pop()!='['){
						return false;
					}
				} else {
					if(stk.isEmpty() ||stk.pop()!='{') {
						return false;
					}
				}
			}
		}

		return stk.isEmpty();
	} // end 
	
} // end class
