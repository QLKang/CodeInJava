package leetcode.dp.uniquebinarysearchtreeiii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniqueBSTII {
	public List<TreeNode> generateTrees(int n){
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(n<=0){
            res.add(null);		    
			return res;
		}
		
		HashMap<Point, List<TreeNode>> map = new HashMap<Point, List<TreeNode>>();
		Point p = null;
		return helper(1, n, p, map);
	}
	
	
	
	private List<TreeNode> helper(int start, int end, Point p,  HashMap<Point, List<TreeNode>> map){
		if(map.containsKey(p)){
			return map.get(p);
		}
		
		
		
		List<TreeNode> res = new ArrayList<TreeNode>();
		
		if(start==end){
			Point newP = new Point(start, end);
			res.add(new TreeNode(start));
			map.put(newP, res);
			return res;
		}
		if(start>end){
			res.add(null);
			return res;
		}
		
		
		List<TreeNode> leftList = null, rightList = null;
		for(int i=start; i<=end; i++){
			leftList = helper(start, i-1, p, map);
			rightList = helper(i+1, end, p, map);
			for(int l=0; l<leftList.size(); l++){
				for(int r = 0; r<rightList.size(); r++){
					TreeNode root = new TreeNode(i);
					root.left = leftList.get(l);
					root.right = rightList.get(r);
					res.add(root);
					Point newP = new Point(start, end);
					map.put(newP, res);
				}
			}
		}
		
		return res;
	}
} // end classs

class Point{
	int x;
	int y;
	public Point(int i, int j){
		x = i;
		y = j;
	}
}