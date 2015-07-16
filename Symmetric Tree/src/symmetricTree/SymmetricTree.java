package symmetricTree;
//20150627
//1.�õ��� InvertBinaryTree�ڵĽ�����ת�ķ���
//2.�õ���sameTree�ж����Ƿ���ͬ
public class SymmetricTree {

	/**
	 * @param args
	 */
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	public static void swap(TreeNode root){
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
	}
	/*
	 * 1.��������ת
	 * 2.��������ת
	 * 3.������������
	 */
	public static TreeNode invertTree(TreeNode root) {
		if(root.left==null&&root.right==null){
			return null;
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
	public static boolean SameTree(TreeNode tr,TreeNode mir){
		if(tr==null||mir==null){
			if(tr==null&&mir==null){
				return true;
			}
			else{
				return false;
			}
		}
		if(tr.val!=mir.val){
			return false;
		}
		return SameTree(tr.left,mir.left)&&SameTree(tr.right,mir.right);
	}
	public static boolean isSymmetric(TreeNode root) {
		if(root==null){
			return true;
		}
        TreeNode mirror=saveTree(root);
        invertTree(root);
        return SameTree(root,mirror);
    }
	public static TreeNode saveTree(TreeNode root){
		TreeNode save=new TreeNode(root.val);
		if(root.left!=null){
			save.left=saveTree(root.left);
		}
		if(root.right!=null){
			save.right=saveTree(root.right);
		}
		return save;
	}
	//
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
		

		
		System.out.println(isSymmetric(null));
	}

}
