package binaryTreeInorderTraversal;
//2015-03-24
import java.util.ArrayList;
import java.util.List;


public class BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
	public static class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst_left=new ArrayList<Integer>(),lst_right=new ArrayList<Integer>();
        List<Integer> lst_rt=new ArrayList<Integer>();
        //leetcode没有检验传入一个空的树的情况
        if(root!=null){
        	lst_left=inorderTraversal(root.left);
        	lst_rt=lst_left;
        	lst_rt.add(root.val);
        	lst_right=inorderTraversal(root.right);
        	lst_rt.addAll(lst_right);
        }
		return lst_rt;
    }
    public TreeNode CreateTree(TreeNode root,int[] A){
    	TreeNode tn=new TreeNode(-1);
    	return tn;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tn=null;
		List<Integer> lst=new ArrayList<Integer>();
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
/*		lst.add(2);
		lst.add(3);*/
		System.out.println(lst);
//		System.out.println(inorderTraversal(tn));
	}

}
