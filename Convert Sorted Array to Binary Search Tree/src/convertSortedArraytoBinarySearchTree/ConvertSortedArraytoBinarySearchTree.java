package convertSortedArraytoBinarySearchTree;
//20150701
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvertSortedArraytoBinarySearchTree {

	/**
	 * @param args
	 */
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	//树要求右边比左边大，因此必须以中间的数值为root
//	public static TreeNode listToBST(List<Integer> lst){
//		if(lst.size()==0){
//			return null;
//		}
//		List<TreeNode> adj=new ArrayList<TreeNode>();
//		TreeNode root=new TreeNode(lst.get(0));
//		adj.add(root);
//		lst.remove(0);
//		while(lst.size()!=0){
//			/*for(Iterator<TreeNode> itr=adj.iterator();itr.hasNext();){
//				TreeNode tr=itr.next();
//				itr.remove();
//				if(tr.left==null){
//					tr.left=new TreeNode(lst.get(0));
//					adj.add(tr.left);
//					lst.remove(0);
//				}
//				
//				if(tr.right==null){
//					tr.right=new TreeNode(lst.get(0));
//					adj.add(tr.right);
//					lst.remove(0);
//				}
//			}*/
//			while(true){
//				TreeNode tn=adj.get(0);
//				if(lst.size()!=0){
//					tn.left=new TreeNode(lst.get(0));
//					adj.add(tn.left);
//					lst.remove(0);
//				}else{
//					break;
//				}
//				if(lst.size()!=0){
//					tn.right=new TreeNode(lst.get(0));
//					adj.add(tn.right);
//					lst.remove(0);
//				}else{
//					break;
//				}
//				adj.remove(0);
//			}
//			
//		}
//		return root;
//	}
//	public static List<Integer> sortedToList(int[] nums){
//		List<Integer> lst=new ArrayList<Integer>();
//		for(int i:nums){
//			lst.add(i);
//		}
//		return lst;
//	}
//	public static TreeNode sortedArrayToBST(int[] nums) {
//        List<Integer> lst=sortedToList(nums);
//        TreeNode tn=listToBST(lst);
//		return tn;  
//    }
	public static void print_tree_pre(TreeNode tn){
		if(tn==null){
			return;
		}
		print_tree_pre(tn.left);
		System.out.print(tn.val+" ");
		print_tree_pre(tn.right);
		
	}
	public static TreeNode sort(int[] nums,int begin,int end){
		if(begin>end){
			return null;
		}
		int middle=nums[(begin+end+1)/2];
		int left_begin=begin,left_end=(begin+end+1)/2-1;
		int right_begin=(begin+end+1)/2+1,right_end=end;
		TreeNode tn=new TreeNode(middle);
		
		tn.left=sort(nums,left_begin,left_end);
		tn.right=sort(nums,right_begin,right_end);
		return tn;
	}
	public static TreeNode sortedArrayToBST(int[] nums) {
        return sort(nums,0,nums.length-1); 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<Integer> lst=new ArrayList<Integer>();
//		lst.add(1);
//		lst.add(2);
//		lst.add(3);
//		lst.add(4);
		int[] nums=new int[]{};
		
		TreeNode tn=sortedArrayToBST(nums);
		print_tree_pre(tn);
	}

}
