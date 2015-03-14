package leetcode.string.simplifypath;

import java.util.LinkedList;
// 02/22/2015
public class SimplifyPath {

	// assumption: absolute path (start from '/')
	public String simplifyPath(String path) {
		LinkedList<String> stack = new LinkedList<String>();
		String[] pathsplit = path.split("/");
		for (String p : pathsplit) {
			if (p.equals("..") && !stack.isEmpty()) { // stack pop
				stack.removeLast();
			} else if (p.length() != 0 && !p.equals(".") && !p.equals("..")) {
				stack.addLast(p); // stack push
			} // other cases: do nothing
		}
		StringBuilder sb = new StringBuilder();
		if (stack.isEmpty())
			return "/"; // !!! corner case
		for (String p : stack) { // build output
			sb.append("/");
			sb.append(p);
		}
		return sb.toString();
	}

}
//String path = "/home/../hadoop/";