package sumRoottoLeafNumbers;
//this question is not too difficult in the medium
//but i think that it is a useful question solved by recursion
//2015-02-22  225ms
//Recording my view by english from now on
public class SumRoottoLeafNumbers {

	/**
	 * @param args
	 */

	public static class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
    public static int sumNumbers(TreeNode root) {
    	int left=0,right=0;
    	if(root==null){
    		return 0;
    	}
    	if(root.left!=null){
    		root.left.val=10*root.val+root.left.val;
    		left=sumNumbers(root.left);
    	}
    	if(root.right!=null){
    		root.right.val=10*root.val+root.right.val;
    		right=sumNumbers(root.right);
    	}
    	if(root.left==null&&root.right==null){
    		return root.val;
    	}
    	return right+left;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.right.right=new TreeNode(5);
		TreeNode root1=null;
		System.out.println(sumNumbers(root1));
		
	}

}
