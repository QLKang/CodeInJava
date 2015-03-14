package leetcode.dfs.permutationsequence;

import java.util.ArrayList;

public class PermutationSequence {
/*--Update: 02/12/2015--*/
	public String getPermutation(int n, int k) {
		// corner case
		if(n<=0||k<=0) 
			return "";
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=1; i<=n; i++){
			arr.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		int nfactorial = factorial(n);
		if(k>nfactorial) return "";
//		helper2(arr, n, k, sb, nfactorial);
		helper3(n , k, arr, sb);
		return sb.toString();
	}

	
	private void helper1(ArrayList<Integer> arr, int n, int k, StringBuilder sb){
		// base case
		if(n==2){
			if(k==1)
				sb.append(arr.get(0)).append(arr.get(1));
			else
				sb.append(arr.get(1)).append(arr.get(0));
			return;
		}
		// recursive part
		int idc = k/factorial(n-1);
		int idr = k%factorial(n-1);
		sb.append(arr.get(idc));
		arr.remove(idc);
		helper1(arr, n-1, idr, sb);
	} // end
	
	private int factorial(int n){
		if(n==0||n==1) return n;
		int res = 1;
		while(n>1){
			res = res*n;
			n--;
		}
		return res;
	}
	
	
	private void helper2(ArrayList<Integer> arr, int n, int k, StringBuilder sb, int factorial){
		// base case
		if(n==2){
			if(k==1)
				sb.append(arr.get(0)).append(arr.get(1));
			else
				sb.append(arr.get(1)).append(arr.get(0));
			return;
		}
		// recursive part
		factorial = factorial/n;
		int idc = k/factorial;
		int idr = k%factorial;
		sb.append(arr.get(idc));
		arr.remove(idc);
		helper2(arr, n-1, idr, sb, factorial);
	} // end
	
	private void helper3(int n ,int k, ArrayList<Integer> arr, StringBuilder sb){
//		StringBuilder sb  = new StringBuilder();
		if(n==1 && k==1){
			sb.append(1);
			return;
		}
		
		int factor = factorial(n);
		factor = factor/n;
		while(n>2){
			int idc = k/factor;
			k = k%factor;
			sb.append(arr.get(idc));
			arr.remove(idc);
			n--;
			factor = factor/n;
		}
		
		if(k==1)
			sb.append(arr.get(0)).append(arr.get(1));
		else
			sb.append(arr.get(1)).append(arr.get(0));
		return;
		
	} // end helper3
		
} // end
