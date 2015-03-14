package leetcode.string.validpalindrome;

/* update: 02/19/15 */
public class ValidPalindrome {
	public boolean isPalindrome(String s){
		if(s==null)
			return false;
		int i =0, j=s.length()-1;
		s = s.toLowerCase();
		while(i < j){
			if(!(s.charAt(i)>='a'&& s.charAt(i)<='z')&&!(s.charAt(i)>='0' && s.charAt(i)<='9') && i<s.length()){
				i++;
			} else if(!(s.charAt(j)>='a'&& s.charAt(j)<='z')&&!(s.charAt(j)>='0' && s.charAt(j)<='9') && j>0){
				j--;
			} else {
				if(s.charAt(i)!=s.charAt(j)){
					return false;
				}
				i++;
				j--;
			}
		}
		
		return true;
	} // end
	
} // end class
