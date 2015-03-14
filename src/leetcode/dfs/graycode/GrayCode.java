package leetcode.dfs.graycode;

import java.util.ArrayList;
import java.util.List;
/* Update Feb.15, 2015
 * Test case: 
 * n=3, 
 * return 
 * 0 0 0,
 * 0 0 1,
 * 0 1 1,
 * 0 1 0,
 * 
 * 1 1 0,
 * 1 1 1,
 * 1 0 1,
 * 1 0 0
 * 
 * n = 2
 * return 
 * 0 0,
 * 0 1,
 * 
 * 1 1,
 * 1 0
 */
public class GrayCode {
/*-SolI--Update: Feb 15, 2015--*/
	
	public List<Integer> grayCode(int n) {

		if (n == 0) {
			List<Integer> result = new ArrayList<Integer>();
			result.add(0);
			return result;
		}
		// tmp stores the gray code of n = 2
		List<Integer> tmp = grayCode(n - 1);
		// add 1 at the front of each tmp element
		int addNumber = 1 << (n - 1);
		
		List<Integer> result = new ArrayList<Integer>(tmp);

		for (int i = tmp.size() - 1; i >= 0; i--) {
			result.add(addNumber + tmp.get(i));
		}
		return result;
	}
	
/*-SolII -------------------*/	
	public List<Integer> grayCode2(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
		if (n < 0)
			return arr;

		arr.add(0); // initialize the arr.

		for (int i = 1; i <= n; i++) { // if n=0, for loop will not be excuted
			int sz = arr.size();
			for (int j = sz - 1; j >= 0; j--) {
				int key = arr.get(j);
				key = key | 1 << (i - 1);
				arr.add(key);
			}
		}
		return arr;
    } // end method

} // end class
