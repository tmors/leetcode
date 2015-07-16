package isValidBST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//ac 2015-4-17
public class IsValidBST {

	/**
	 * @param args
	 */
	public static class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
    public static boolean isValidBST(TreeNode root) {
    	List<Integer> lst=new ArrayList<Integer>();
    	if(root==null){
    		return true;
    	}
    	midsearch(root,lst);
    	//左子树小于根节点，右子树大于根节点，不包括等于
    	for(int i=0;i<lst.size()-1;i++){
    		if(lst.get(i)>lst.get(i+1)){
    			return false;
    		}
    	}
        return true;
    }
    public static void midsearch(TreeNode root,List<Integer> lst){
		if(root.left!=null){
			midsearch(root.left,lst);
		}
		lst.add(root.val);
		if(root.right!=null){
			midsearch(root.right,lst);
		}
    }
    //非递归中序遍历 未完成---------------------------------
    public static  List<Integer> midsearch_nonrecruit(TreeNode root){
    	List<Integer> lst=new ArrayList<Integer>();
		return lst;
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lst=new ArrayList<Integer>();
		TreeNode trn=new TreeNode(6);
		trn.left=new TreeNode(5);
		trn.right=new TreeNode(7);
		trn.left.left=new TreeNode(2);
		trn.left.right=new TreeNode(5);
		trn.right.right=new TreeNode(1);
		TreeNode temp=new TreeNode(1);;
		temp.left=new TreeNode(1);
		midsearch(trn,lst);
		Iterator<Integer> itr=lst.iterator();
		System.out.println(isValidBST(temp));
		
	
		
	}

}
