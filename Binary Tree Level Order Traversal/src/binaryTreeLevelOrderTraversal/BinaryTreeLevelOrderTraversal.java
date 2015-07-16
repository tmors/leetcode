package binaryTreeLevelOrderTraversal;
//20150706
//2可以复用1的代码
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val=x;
		}
	}
	public static List<TreeNode> next_level(List<TreeNode> root){
		List<TreeNode> next=new ArrayList<TreeNode>();
		for(Iterator<TreeNode> itr=root.iterator();itr.hasNext();){
			TreeNode cur=itr.next();
			if(cur.left!=null){
				next.add(cur.left);
			}
			if(cur.right!=null){
				next.add(cur.right);
			}
		}
		return next;
	}
	public static List<Integer> tree2list(List<TreeNode> tr){
		List<Integer> nums=new ArrayList<Integer>();
		for(Iterator<TreeNode> itr=tr.iterator();itr.hasNext();){
			nums.add(itr.next().val);
		}
		return nums;
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
       List<TreeNode> tr=new ArrayList<TreeNode>();
       List<Integer> lst=new ArrayList<Integer>();
       List<List<Integer>> list_lst=new ArrayList<List<Integer>>();
       if(root==null){
    	   return list_lst;
       }
       tr.add(root);
       lst.add(root.val);
       list_lst.add(lst);
		while(tr.size()!=0){
			tr=next_level(tr);
			lst=tree2list(tr);
			if(lst.size()!=0){
				list_lst.add(lst);	
			}
		}
		list_lst=reverse(list_lst);
		return list_lst;
    }
	public static List<List<Integer>> reverse(List<List<Integer>> list_lst){
		List<List<Integer>> list_reverse=new ArrayList<List<Integer>>();
		int len=list_lst.size();
		int i=0;
		while(i<len){
			list_reverse.add(list_lst.get(len-1-i));
			i++;
		}
		return list_reverse;
	}
	public static void print_list(List<List<Integer>> list_lst){
		for(List<Integer> lst:list_lst){
			for(int i:lst){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		List<List<Integer>> list_lst=levelOrder(null);
		print_list(list_lst);
	}

}
	