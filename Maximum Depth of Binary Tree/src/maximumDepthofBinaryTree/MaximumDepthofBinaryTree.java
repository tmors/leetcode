package maximumDepthofBinaryTree;


public class MaximumDepthofBinaryTree {

	/**
	 * @param args
	 */
	public static class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	public static int maxDepth(TreeNode root) {
        if(root==null){
        	return 0;
        }
        if(root.left!=null||root.right!=null){
        	return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        else {
        	return 1;
        }
		
		
    }
	public static TreeNode makeTree(int[] A){
		
		TreeNode p=new TreeNode(A[0]);
		return p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode p=new TreeNode(1),q=null;
	    int[] A={2,3};
		for(int i=0;i<A.length;i++){
	    	p.left=new TreeNode(A[i++]);
	    	p.right=new TreeNode(A[i]);
	    }
		p.left.left=new TreeNode(3);
		p.left.left.right=new TreeNode(4);
		System.out.println(maxDepth(p));
	}

}
