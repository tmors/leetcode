package invertBinaryTree;
//2015-06-27
import java.util.Stack;

public class InvertBinaryTree {

	/**
	 * @param args
	 */
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	/*
	 * 1.将左子树反过来（镜面）
	 * 2.将右子数反过来
	 * 3.将左子树与右子树交换
	 */
	public static void mirror(TreeNode root){
		
	}
	public static void swap(TreeNode root){
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
	}
	public static TreeNode invertTree(TreeNode root) {
	    if(root==null){
	        return root;
	    }
		if(root.left==null&&root.right==null){
			return root;
		}
		if(root.left!=null){
			invertTree(root.left);
		}
        if(root.right!=null){
        	invertTree(root.right);
        }
        swap(root);
        return root;
    }
	public static void nums2tree(int[] nums){
		TreeNode tn=new TreeNode(nums[0]);
		
	}
	public static void print_tree_pre(TreeNode tr){
		if(tr==null){
			return;
		}
		System.out.print(tr.val+" ");
		print_tree_pre(tr.left);
		print_tree_pre(tr.right);	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tr=new TreeNode(4);
		tr.left=new TreeNode(2);
		tr.right=new TreeNode(7);
		tr.left.left=new TreeNode(1);
		tr.left.right=new TreeNode(3);
		tr.right.left=new TreeNode(6);
		tr.right.right=new TreeNode(9);
		invertTree(tr);
		print_tree_pre(tr);
	}

}
