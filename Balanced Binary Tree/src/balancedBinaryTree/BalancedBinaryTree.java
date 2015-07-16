package balancedBinaryTree;
//20150627
//如何用非递归的方法求树的高度
public class BalancedBinaryTree {

	/**
	 * @param args
	 */
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	public static int tree_height(TreeNode root){
		if(root==null){
			return 0;
		}
		return Math.max(tree_height(root.left), tree_height(root.right))+1;
	}
	public static boolean isBalanced(TreeNode root) {
        if(root==null){
        	return true;
        }
        if(Math.abs(tree_height(root.left)-tree_height(root.right))>1){
        	return false;
        }
        else{
        	return isBalanced(root.left)&&isBalanced(root.right);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tr=new TreeNode(1);
		tr.left=new TreeNode(2);
		tr.left.left=new TreeNode(1);
		System.out.println(isBalanced(tr));
	}

}
