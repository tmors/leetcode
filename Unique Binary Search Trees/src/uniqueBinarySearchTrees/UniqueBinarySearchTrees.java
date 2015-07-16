package uniqueBinarySearchTrees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import uniqueBinarySearchTrees.UniqueBinarySearchTrees.TreeNode;
//20150706 当为空时，需要返回一个[[]]，即添加一个null进ltn
//前面那题不能通过求出所有的list从而求得数量，会在19超时
public class UniqueBinarySearchTrees {

	/**
	 * @param args
	 *
	 */
	//20150706 11:24完成从伪码至java
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val=x;
		}
	}
	public static void add_list(List<TreeNode> lst_left,List<TreeNode> lst_right,int root,List<TreeNode> ltn){
		if(lst_left==null||lst_right==null){
			if(lst_left==null){
				for(Iterator<TreeNode> itr=lst_right.iterator();itr.hasNext();){
					TreeNode tr=new TreeNode(root);
					tr.left=null;
					tr.right=itr.next();
					ltn.add(tr);
				}	
			}
			if(lst_right==null){
				for(Iterator<TreeNode> itr=lst_left.iterator();itr.hasNext();){
					TreeNode tr=new TreeNode(root);
					tr.left=itr.next();
					tr.right=null;
					ltn.add(tr);
				}
			}
			
		}
		else{	
		for(Iterator<TreeNode> itl=lst_left.iterator();itl.hasNext();){
			TreeNode left=itl.next();
			for(Iterator<TreeNode> itr=lst_right.iterator();itr.hasNext();){
				TreeNode tr=new TreeNode(root);
				tr.left=left;
				tr.right=itr.next();
				ltn.add(tr);
			}
		}
	}
	}
	public static List<TreeNode> canTree(int begin,int end){
		List<TreeNode> ltn=new ArrayList<TreeNode>();
		if(begin>end){
			ltn.add(null);
			return ltn;
		}
		if(begin==end){
			TreeNode tr=new TreeNode(begin);
			ltn.add(tr);
			return ltn;
		}
		int i=begin-1;
		while(i<=end-1){
			List<TreeNode> list_left=canTree(begin,i);
			List<TreeNode> list_right=canTree(i+2,end);
			add_list(list_left,list_right,i+1,ltn);
			i++;
		}
		return ltn;
	}
    public static int numTrees(int n) {
    	List<TreeNode> i=canTree(1,n);
    	return i.size();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TreeNode> ltn=canTree(1,0);
		int n=numTrees(6);
		System.out.println(n);
	}

}
