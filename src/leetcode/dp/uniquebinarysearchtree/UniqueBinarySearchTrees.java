package leetcode.dp.uniquebinarysearchtree;

public class UniqueBinarySearchTrees {
	
	public int numTrees1(int n){
		if(n<=0) 
			return 0;
		if(n==1)
			return 1;
		if(n==2)
			return 2;

		int left = 1, right = 1;
		int sum = 0;
		for(int i=1; i<=n; i++){
			if(i==1)
				left = 1;
			else
				left = numTrees1(i-1);
			if(i==n)
				right = 1;
			else 
				right = numTrees1(n-i);
			
			
			sum+=left*right;
		}
		
		return sum;
	}
	
	
	/*---DP---*/
	public int numTrees(int n){
		if(n<=0) 
			return 0;
		int[] f = new int[n+1];
		return helper(n, f);
	
	}
	
	private int helper(int n, int[] f){
		if(n==0||n==1)
			return 1;
		
		if(f[n]>0)
			return f[n];
		
		for(int i=1; i<=n; i++){
			int left = helper(i-1, f);
			int right = helper(n-i, f);
			f[n]=f[n]+left*right;
		}
		
		return f[n];
	}
	
} // end class
