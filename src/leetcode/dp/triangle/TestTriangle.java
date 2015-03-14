package leetcode.dp.triangle;

import java.util.ArrayList;
import java.util.List;

public class TestTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle sol = new Triangle();
		List<Integer> l0 = new ArrayList<Integer>();
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		
		l0.add(2);
		l1.add(3);l1.add(4);
		l2.add(6);l2.add(5);l2.add(7);
		l3.add(4);l3.add(1);l3.add(8);l3.add(3);
		
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(l0);
		triangle.add(l1);
		triangle.add(l2);
		triangle.add(l3);
		
		int res = sol.minimumTotal(triangle);
		System.out.println(res);
		
		
	}

}
