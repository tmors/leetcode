package minimumDepthofBinaryTree;

public class MinimumDepthofBinaryTree {

	/**
	 * @param args
	 */
	public static class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
    public static int minDepth(TreeNode root) {
/*        if(root==null){
        	return 0;
        }
        if(root.left!=null&root.right!=null){
        	return 1+Math.min(minDepth(root.left),minDepth(root.right));
        }
        else if(root.left==null&&root.right==null){
        	return 1;
        }
        else{
        	return 1+(root.left==null?minDepth(root.right):minDepth(root.left));
        }*/
    	
		if(root==null){
			return 0;
		}
		if(root.left!=null||root.right!=null){
			int path=Math.min(minDepth(root.left), minDepth(root.right));
			if(path==0){
				path=Math.max(minDepth(root.left), minDepth(root.right));
				return path+1;
			}
			else{
				return 1+path;
			}
		}
			return 1;
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode p=new TreeNode(1),q=null;
	    int[] A={2,3};
		for(int i=0;i<A.length;i++){
	    	p.left=new TreeNode(A[i++]);
//	    	p.right=new TreeNode(A[i]);
	    }
		p.left.right=new TreeNode(3);
//		p.left.left.right=new TreeNode(4);
		p.left.right.right=new TreeNode(4);
		System.out.println(minDepth(p));
	}

}
